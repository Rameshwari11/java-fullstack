package com.cgi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dto.UserDto;
import com.cgi.entity.User;
import com.cgi.entity.UserEntity;
import com.cgi.model.UserResponseModel;
import com.cgi.repo.UserEntityRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserEntityRepository userEntityRepository;

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		log.info("Inside createUser Service layer");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

		userEntity.setUserId(UUID.randomUUID().toString());

		System.out.println(userEntity);
		userEntityRepository.save(userEntity);
		UserResponseModel responseModel = modelMapper.map(userEntity, UserResponseModel.class);
		return responseModel;
	}

	@Override
	public List<UserEntity> getAllUsers() {

		return userEntityRepository.findAll();
	}

	@Override
	public void deleteUserById(int id) {
		userEntityRepository.deleteById(id);

	}

	@Override
	public void deleteAllUsers() {
		userEntityRepository.deleteAll();

	}

	@Override
	public UserResponseModel getuserById(int id) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserResponseModel userResponseModel = null;

		Optional<UserEntity> result = userEntityRepository.findById(id);

		if (result.isPresent()) {
			userResponseModel = modelMapper.map(result, UserResponseModel.class);

		} else {
			log.info("Id Not FOund " + id);
		}
		return userResponseModel;
	}

	@Override
	public UserResponseModel updateUserById(int id, UserDto userDto) {
		Optional<UserEntity> result = userEntityRepository.findById(id);
		UserResponseModel userResponseModel = null;

		if (result.isPresent()) {
			UserEntity tempResult = result.get();
			System.out.println("Inside setting new values");
			tempResult.setFirstName(userDto.getFirstName());
			tempResult.setLastName(userDto.getLastName());
			tempResult.setEmail(userDto.getEmail());
			userEntityRepository.save(tempResult);
			userResponseModel = modelMapper.map(result, UserResponseModel.class);

		}
		return userResponseModel;
	}

	@Override
	public UserResponseModel findByUserId(String userid) {
		 UserEntity tempResult = userEntityRepository.findByUserId(userid);	 
			 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			return modelMapper.map(tempResult, UserResponseModel.class);
		
	}

	@Override
	public UserResponseModel findByEmail(String email) {
		 UserEntity tempResult = userEntityRepository.findByEmail(email)	 ;
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(tempResult, UserResponseModel.class);
	}

}
