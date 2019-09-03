package com.revature.data.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Gladiator;
import com.revature.beans.User;
import com.revature.data.GladiatorDAO;
import com.revature.utils.HibernateUtil;

@Component
public class GladiatorHibernate implements GladiatorDAO {
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addGladiator(Gladiator g) {
		/*
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		t = s.beginTransaction();
		i = (Integer) s.save(g);
		t.commit();
		
		return i;
		*/
		return 0;
	}

	@Override
	public Gladiator getGladiator(Integer id) {
		Session s = hu.getSession();
		String query = "from Gladiator g where g.id=:id";
		Query<Gladiator> q = s.createQuery(query, Gladiator.class);
		q.setParameter("id", id);
		Gladiator g = q.uniqueResult();
		s.close();
		return g;
	}

	@Override
	public Set<Gladiator> getGladiatorsForUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGladiator(Gladiator g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGladiator(Gladiator g) {
		// TODO Auto-generated method stub
		
	}

}
