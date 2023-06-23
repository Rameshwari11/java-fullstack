

package com.cgi.service;

import java.util.List;

import com.cgi.dto.UserDto;
import com.cgi.entity.UserEntity;
import com.cgi.model.UserResponseModel;

public interface UserService {

	public UserResponseModel createUser(UserDto userDto);
	
	public  List<UserEntity> getAllUsers();
	
	public UserResponseModel getuserById(int id);

	public void deleteUserById(int id);

	public UserResponseModel updateUserById(int id,UserDto userDto);

	public void deleteAllUsers();
	
	public UserResponseModel findByUserId(String userid);
	
	public UserResponseModel findByEmail(String email);

}
