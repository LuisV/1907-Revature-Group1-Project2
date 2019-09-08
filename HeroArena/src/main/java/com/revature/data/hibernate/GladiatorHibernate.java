package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
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
	private Logger log = Logger.getLogger(GladiatorHibernate.class);
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public Integer addGladiator(Gladiator g) {
		log.trace("Adding gladiator to database");
		log.trace(" > " + g);

		Integer id = null;
		Session sess = hu.getSession();
		Transaction tx = null;
		try
		{
			tx = sess.beginTransaction();
			id = (Integer) sess.save(g);
			tx.commit();
			log.trace(" > Gladiator successfully added! data=" + g);
			log.trace(g + "   ----- id=" + id);
		} catch (Exception e)
		{
			log.warn("Failed to add gladiator to database");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally
		{
			sess.close();
		}

		return id;
	}

	// not testing atm
	@Override
	public Gladiator getGladiator(Integer id) {
		System.out.println("calling getGladiator");
		Session s = hu.getSession();
		String query = "from Gladiator g where g.id=:id";
		Query<Gladiator> q = s.createQuery(query, Gladiator.class);
		q.setParameter("id", id);
		Gladiator g = q.uniqueResult();
		s.close();
		return g;
	}
	/*
	@Override
	public Set<Gladiator> getGladiatorsForUser(User u) {
		System.out.println("calling getGladiatorForUser");
		Session s = hu.getSession();
		String query = "from Gladiator g where g.id=:id";
		Query<Gladiator> q = s.createQuery(query, Gladiator.class);
		q.setParameter("id", u.getId());
		List<Gladiator> gladList = q.getResultList();
		Set<Gladiator> gladSet = new HashSet<Gladiator>();
		gladSet.addAll(gladList);
		s.close();
		return gladSet;
	}
	*/
	@Override
	public Set<Gladiator> getGladiatorsForUser(User u) {
		System.out.println("calling getGladiatorForUser in gladiatorHibernate");
		Session s = hu.getSession();
		String query = "from Gladiator g where g.player=:i";
		Query<Gladiator> q = s.createQuery(query, Gladiator.class);
		//q.setParameter("id", u.getId());
		q.setParameter("i", u);
		List<Gladiator> gladList = q.getResultList();
		System.out.println(gladList);
		Set<Gladiator> gladSet = new HashSet<Gladiator>();
		gladSet.addAll(gladList);
		s.close();
		return gladSet;
	}

	@Override
	public Set<Gladiator> getGladiatorsNotOwnedBy(User user)
	{
		log.trace("Getting all gladiators not owned by a given user");
		log.trace(" > " + user);

		String qStr = "from Gladiator g where g.player.id != :userId";
		Session s = hu.getSession();
		Query<Gladiator> query = s.createQuery(qStr, Gladiator.class);
		query.setParameter("userId", user.getId());
		Set<Gladiator> results = new HashSet<Gladiator>(query.list());

		s.close();

		return results;
	}

	@Override
	public Set<Gladiator> getAllGladiators() {
		System.out.println("calling getAllGladiators");
		Session s = hu.getSession();
		String query = "from Gladiator";
		Query<Gladiator> q = s.createQuery(query, Gladiator.class);
		Set<Gladiator> allGlad =  new HashSet<>(q.getResultList());

		s.close();
		return allGlad;
	}


	@Override
	public void updateGladiator(Gladiator g) {
		// TODO Auto-generated method stub
		
		System.out.println("calling updateGladiator in the Hibernate");
		System.out.println(g);
		
		
		//String query = "UPDATE Gladiator setg where g.id=:i";
		/*
		String query = "UPDATE Gladiator set strength=:strength," + 
				" dexterity=:dexterity, vitality=:vitality " + 
				"where id=:id";
		*/
		/*
		Query q = s.createQuery(query);
		q.setParameter("id", g.getId());
		q.setParameter("strength", g.getStrength());
		q.setParameter("dexterity", g.getDexterity());
		q.executeUpdate();
		*/
		
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(g);
			tx.commit();
		} catch (Exception e) {
			 //log.warn("Failed to update user item: " + userItem);
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
	}

	@Override
	public void deleteGladiator(Gladiator g) {
		// TODO Auto-generated method stub
		
	}

}
