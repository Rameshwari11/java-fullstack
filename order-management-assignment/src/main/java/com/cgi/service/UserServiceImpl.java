package com.cgi.service;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cgi.dao.impl.UserDaoImpl;

@Component("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoImpl userDaoImpl;

	@Override
	public boolean validateLogin(int userId, String password) throws SQLException {
		
		return userDaoImpl.validateLogin(userId, password);
	}

}
