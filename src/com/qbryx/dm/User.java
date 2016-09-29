package com.qbryx.dm;

public class User {
	
	private int user_type;
	private String username;
	private String password;
	
	public User(int user_type, String username, String password) {
		super();
		this.user_type = user_type;
		this.username = username;
		this.password = password;
	}
	
	public User(){
		
	}

	public int getUserType() {
		return user_type;
	}
	
	public void setUserType(int user_type_id) {
		this.user_type = user_type_id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
