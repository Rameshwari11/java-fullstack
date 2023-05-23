package com.cgi.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cgi.dao.UserDao;


@Component("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public boolean validateLogin(int userId, String password) throws SQLException {
		
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from users where userid='"+userId+"' and password = '"+password+"'");
		while (resultSet.next()) {
			return true;
		}
		return false;
	}

}
