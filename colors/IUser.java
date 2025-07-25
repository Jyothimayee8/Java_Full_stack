package com.colors;

public interface IUser {
	boolean register(User user,int index);
	boolean login(String username,String password);
}
