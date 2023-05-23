package com.cgi.dao;

import java.sql.SQLException;

public interface UserDao {
	
	public boolean validateLogin(int userId ,String password) throws SQLException;

}
