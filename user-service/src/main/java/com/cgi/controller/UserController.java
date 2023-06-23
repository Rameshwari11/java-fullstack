package com.cgi.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.dto.UserDto;
import com.cgi.entity.UserEntity;
import com.cgi.exception.MyCustomException;
import com.cgi.model.ErrorModel;
import com.cgi.model.UserRequestModel;
import com.cgi.model.UserResponseModel;
import com.cgi.repo.RoleRepository;
import com.cgi.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private  ModelMapper modelMapper;
	@Autowired
	private  UserService userService;
	
	@Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	
	@ExceptionHandler(value = NumberFormatException.class)	
	public ResponseEntity<ErrorModel> handleException(NumberFormatException e)
	{
		ErrorModel errorModel=new ErrorModel(HttpStatus.BAD_REQUEST.value(), 
				e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
	}
	
	@ExceptionHandler({MyCustomException.class ,IllegalArgumentException.class ,EmptyResultDataAccessException.class})
	public ResponseEntity<ErrorModel> handleIdNotFoundException(Exception e) {
		ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorModel);

	}
	
	@PostMapping
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel requestModel) {
		
		log.info("Inside createUser method");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(requestModel, UserDto.class);
		StringBuffer sb = new StringBuffer();
		sb.append(requestModel.getPassword());
		userDto.setEncrytedPassword(sb.reverse().toString());

		System.out.println(userDto);
		UserResponseModel responseModel = userService.createUser(userDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);

	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseModel>> getAllUsers()
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserResponseModel> result = new ArrayList<>();
		
		List<UserEntity> tempResult = userService.getAllUsers();
		
		for (UserEntity value : tempResult)
		{
			result.add(modelMapper.map(value, UserResponseModel.class));
		}
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllUsers(@PathVariable int id) throws NumberFormatException,MyCustomException
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserResponseModel result=userService.getuserById(id);
		if(result !=null)
		{
			return ResponseEntity.ok(result);
		}
		else
		{
			throw new MyCustomException("user with id: "+id+" not found");
		}
		
	}
	
	@GetMapping("/findByUserId/{userId}")
	public ResponseEntity<?> getByUserId(@PathVariable String userId) throws IllegalArgumentException
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserResponseModel result=userService.findByUserId(userId);
		if(result !=null)
		{
			return ResponseEntity.ok(result);
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable String email) throws IllegalArgumentException
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserResponseModel result=userService.findByEmail(email);
		if(result !=null)
		{
			return ResponseEntity.ok(result);
		}
		else
		{
			throw new IllegalArgumentException();
		}
		
	}
	
	@DeleteMapping("/{id}") 
	public void deleteUserById(@PathVariable int id) throws EmptyResultDataAccessException
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		userService.deleteUserById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseModel> updateUser(@PathVariable int id,@RequestBody UserRequestModel requestModel) {
		
		log.info("Inside updateUser method");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(requestModel, UserDto.class);
		StringBuffer sb = new StringBuffer();
		sb.append(requestModel.getPassword());
		userDto.setEncrytedPassword(sb.reverse().toString());

		UserResponseModel responseModel = userService.updateUserById(id, userDto);

		return ResponseEntity.status(HttpStatus.OK).body(responseModel);

	}
	
	@DeleteMapping
	public void deleteAllUsers()
	{
		userService.deleteAllUsers();
		
	}
	
}
