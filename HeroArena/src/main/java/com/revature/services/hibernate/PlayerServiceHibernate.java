package com.revature.services.hibernate;

import java.util.Set;

import com.revature.beans.Player;
import com.revature.data.PlayerDAO;
import com.revature.data.UserDAO;
import com.revature.data.hibernate.PlayerHibernate;
import com.revature.data.hibernate.UserHibernate;
import com.revature.services.PlayerService;

public class PlayerServiceHibernate implements PlayerService {
	private UserDAO ud = new UserHibernate();
	private PlayerDAO pd = new PlayerHibernate();
	
	
	public Player getPlayer(String username, String password) {
		Player play = new Player(null, username, password);
		play = (Player) ud.getUser(username, password);
		return play;
	}

	public Player getPlayerById(int i) {
		Player play = new Player(i);
		
		return null;
	}

	public Set<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

}
