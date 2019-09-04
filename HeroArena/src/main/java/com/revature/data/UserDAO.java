package com.revature.data;

import java.util.Set;

import com.revature.beans.Gladiator;
import com.revature.beans.User;

public interface UserDAO {
	public int addUser(User user);
	public User getUser(String username, String password);
	public User banUser(User u);
	public User getUser(Integer id);
	public Set<Gladiator> getRoster(User u);
}
