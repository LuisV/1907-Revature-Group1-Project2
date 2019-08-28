package com.revature.data;

import com.revature.beans.Admin;
import com.revature.beans.User;

public interface AdminDAO {
	public int addAdmin(Admin user);
	public User getAdmin(String username, String password);
	public User disableAdmin(Admin u);

}
