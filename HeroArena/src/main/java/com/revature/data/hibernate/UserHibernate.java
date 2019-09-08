package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.beans.Character;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Gladiator;
import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class UserHibernate implements UserDAO {
	@Autowired
	private HibernateUtil hu;
	@Override
	public int addUser(User user) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(user);
			t.commit();
		} catch (HibernateException e) {
			t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		return i;
	}

	public User getUser(String username, String password) {
		Session s = hu.getSession();
		// "from Users u" maybe?
		String query = "from User u where u.username=:username and u.password=:password";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		User u = q.uniqueResult();
		s.close();
		return u;
	}

	public User banUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(Integer id) {
		Session s = hu.getSession();
		String query = "from User u where u.id=:id";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("id", id);
		User u = q.uniqueResult();
		s.close();
		return u;
	}

	
	//@RequestMapping(value="/user/roster")
	public Set<Gladiator> getRoster(User u) {
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

	@Override
	public Set<User> getAllUsers() {
		System.out.println("calling getAllUsers");
		Session s = hu.getSession();
		String query = "from User";
		Query<User> q = s.createQuery(query, User.class);
		Set<User> allUserss =  new HashSet<>(q.getResultList());

		s.close();
		return allUserss;
	}

	@Override
	public User editUser(User u) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t= s.beginTransaction();
			s.update(u);
			t.commit();
		} catch (Exception e){
			if(t != null)
				t.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}

		return u;
	}
}
