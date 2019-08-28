package com.revature.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;


public class UserHibernate implements UserDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
	
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

}
