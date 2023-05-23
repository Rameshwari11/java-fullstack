package com.cgi.model;

public class Users {

	private int userId;
	private String password ;
	
	public Users() {
		super();
	}
	public Users(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + "]";
	}
	
}
