package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.data.UserDAO;

import java.util.Set;

@Service
public class UserService {
	@Autowired
	private UserDAO ud;

	public User login(String username, String password) {
		return ud.getUser(username, password);
	}

	public User registerUser(String username, String password)
	{
		if (username == null || password == null || username.length() < 3 || password.length() < 6)
			return null;

		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setRole(1);

		int key = ud.addUser(newUser);
		newUser.setId(key);

		// Registration failed
		if (key < 1)
			return null;

		return newUser;
	}
	public User getUser(Integer id){
		return ud.getUser(id);
	}
	public Set<User> getAllUsers(){return ud.getAllUsers();}
	public User editUser(User u){return ud.editUser(u);}
}
