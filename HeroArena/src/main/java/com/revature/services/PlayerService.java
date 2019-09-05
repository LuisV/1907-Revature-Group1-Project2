package com.revature.services;

import java.util.Set;

import com.revature.beans.Player;
import com.revature.data.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {

	@Autowired
	private PlayerDAO pd;

	public Player getPlayer(String username, String password) {return  null;}
	public Player getPlayerById(int i){return  null;}
	public Set<Player> getPlayers(){return  null;}
	//public void deletePlayer(Player player);
	//public void updatePlayer(Player player);
	public void addPlayer(Player player){}
}
