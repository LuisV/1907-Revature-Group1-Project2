package com.revature.data;

import java.util.Set;

import com.revature.beans.Gladiator;
import com.revature.beans.Player;

public interface GladiatorDAO {
	public int addGladiator(Gladiator g);
	
	public Gladiator getGladiator(int i);
	
	public Set<Gladiator> getGladiatorsForPlayer(Player p);

	
}
