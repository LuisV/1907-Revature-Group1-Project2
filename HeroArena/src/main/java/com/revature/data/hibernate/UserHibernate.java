package com.revature.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
		// TODO Auto-generated method stub
		return null;
	}

	public User banUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
