package com.facebook;

public class User {
	//fields
			private String username;
			
			private String password;
			
	//default constructor
			
	// constructor
			
	public User(String username, String password) {
				super();
				this.username = username;
				this.password = password;
			}

	 //methods
	 
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
	//to display object info
	@Override
	public String toString() {
		return "User [username= " + username + ",password=" +password + "]";
	}
	public User() {
		super();
	}

	
}
