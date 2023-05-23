package com.cgi.service;

import java.sql.SQLException;

public interface UserService {

	public boolean validateLogin(int userId ,String password) throws SQLException;
}
