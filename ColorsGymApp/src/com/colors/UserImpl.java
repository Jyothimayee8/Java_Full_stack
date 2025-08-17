package com.colors;

public class UserImpl implements IUser {

	

	//array

	private User users[];

	

	//constructor

	public UserImpl()

	{

		users = new User[5];

	}



	@Override

	public boolean register(User user, int index) {

		//business logic

		users[index] = user;

		return false;

	}

		

	@Override

	public boolean login(String username, String password) {

		// business logic

		for(User user:users)

		{

			if(user!=null)

			{

				if(user.getUserName().equals(username)&&user.getPassword().equals(password))

				{

					return true;

				}//inner if

			}//if

		}//for

		return false;

	}

		

}

