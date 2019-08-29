package com.revature.data.hibernate;

import java.util.Set;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Player;
import com.revature.data.PlayerDAO;
import com.revature.utils.HibernateUtil;

public class PlayerHibernate implements PlayerDAO{
	private HibernateUtil hu;
	private Logger log = Logger.getLogger(PlayerHibernate.class);
	
	@Override
	// TODO: need to do it the spring mvc way here
	public void addPlayer(Player player) {
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			s.save(player);
			t.commit();
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
		} finally {
			s.close();
		}
	}

	@Override
	public Player getPlayer(Player player) {
		Session s = hu.getSession();
		Player p = s.get(Player.class, player.getId());
		if (p == null) {
			//String query = fr
		}
		s.close();
		return null;
	}

	@Override
	public Set<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

}
