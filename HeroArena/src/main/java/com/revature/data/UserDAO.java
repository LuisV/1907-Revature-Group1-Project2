package com.revature.data;

import com.revature.beans.User;

public interface UserDAO {
	public int addUser(User user);
	public User getUser(String username, String password);
	public User banUser(User u);
	public User getUser(Integer id);
}
