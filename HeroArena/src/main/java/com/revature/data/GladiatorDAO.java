package com.revature.data;

import java.util.Set;

import com.revature.beans.Gladiator;
import com.revature.beans.Player;
import com.revature.beans.User;

public interface GladiatorDAO {
	// CREATE - Insert
	public int addGladiator(Gladiator g);
	// READ - select
	public Gladiator getGladiator(Integer id);
	public Set<Gladiator> getGladiatorsForUser(User u);
	public Set<Gladiator> getAllGladiators();
	// Update - Update
	void updateGladiator(Gladiator g);
	// Delete
	void deleteGladiator(Gladiator g);

	
}
