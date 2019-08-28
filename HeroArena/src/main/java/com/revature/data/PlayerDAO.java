package com.revature.data;

import java.util.Set;

import com.revature.beans.Player;


public interface PlayerDAO {
	public void addPlayer(Player player);
	public Player getPlayer(Player player);
	public Set<Player> getPlayers();
	
	//public void deletePlayer(Player player);
	
	//public void updatePlayer(Player player);
}
