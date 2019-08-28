package com.revature.services;

import java.util.Set;

import com.revature.beans.Player;

public interface PlayerService {
	public Player getPlayer(String username, String password);
	public Player getPlayerById(int i);
	public Set<Player> getPlayers();
	//public void deletePlayer(Player player);
	//public void updatePlayer(Player player);
	public void addPlayer(Player player);
}
