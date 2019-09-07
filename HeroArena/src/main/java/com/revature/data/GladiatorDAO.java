package com.revature.data;

import java.util.Set;

import com.revature.beans.Gladiator;
import com.revature.beans.Player;
import com.revature.beans.User;

public interface GladiatorDAO {
	// CREATE - Insert
	int addGladiator(Gladiator g);
	// READ - select
	Gladiator getGladiator(Integer id);
	Set<Gladiator> getGladiatorsForUser(User u);
	Set<Gladiator> getAllGladiators();
	Set<Gladiator> getGladiatorsNotOwnedBy(User u);
	// Update - Update
	void updateGladiator(Gladiator g);
	// Delete
	void deleteGladiator(Gladiator g);

	
}
