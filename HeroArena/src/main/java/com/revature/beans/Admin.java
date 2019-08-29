package com.revature.beans;

public class Admin extends User{
	public Admin() {
		super();
	}

	public Admin(Integer id, String username, String password) {
		super(id, username, password, 0);
	}
	
	public void banUser(User user) {
		
	}
	
}
