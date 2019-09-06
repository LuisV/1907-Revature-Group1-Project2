package com.revature.data.hibernate;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserItemStock;
import com.revature.beans.UserItemStockId;
import com.revature.data.UserItemsDAO;
import com.revature.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserItemsHibernate implements UserItemsDAO
{
    private Logger log = Logger.getLogger(ItemHibernate.class);

    @Autowired
    private HibernateUtil hiberUtil;

    @Override
    public UserItemStock addUserItem(Item item, User user)
    {
        log.trace("Adding new user item to database");
        log.trace(" > item=" + item + ", user=" + user);

        UserItemStock userItem = new UserItemStock();
        userItem.setItem(item);
        userItem.setUser(user);
        userItem.setAmount(1);

        Session sess = hiberUtil.getSession();
        Transaction tx = null;
        try
        {
            tx = sess.beginTransaction();
            sess.save(userItem);
            tx.commit();
            log.trace(" > User item successfully added!");
        } catch (Exception e)
        {
            log.warn("Failed to add user item to database");
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
            userItem = null;
        } finally
        {
            sess.close();
        }

        return userItem;
    }

    @Override
    public UserItemStock getUserItemById(Item item, User user)
    {
        log.trace("Getting user item by id (item = " + item + ", user = " + user + ")");


        Session sess = hiberUtil.getSession();
        String query = "from UserItemStock ustock where ustock.user.id=:user and ustock.item.id=:item";
        Query<UserItemStock> qry = sess.createQuery(query, UserItemStock.class);
        qry.setParameter("user", user.getId());
        qry.setParameter("item", item.getId());
        UserItemStock userItem = qry.uniqueResult();
        sess.close();

        log.trace("Retrieved user item: " + userItem);

        return userItem;
    }

    @Override
    public Set<UserItemStock> getUserItemsByUser(User user)
    {
        log.trace("Getting all items by user");
        log.trace(" > " + user);

        Session sess = hiberUtil.getSession();

        //User tempUser = sess.get(User.class, user.getId());

        String query = "from UserItemStock ustock where ustock.user.id=:user";
        Query<UserItemStock> qry = sess.createQuery(query, UserItemStock.class);
        qry.setParameter("user", user.getId());
        Set<UserItemStock> results = new HashSet<UserItemStock>(qry.list());

        sess.close();

        return results;
    }

    @Override
    public boolean deleteUserItem(UserItemStock userItem)
    {
        log.trace("Deleting user item");
        log.trace(" > " + userItem);
        Session sess = hiberUtil.getSession();
        Transaction tx = null;
        try
        {
            tx = sess.beginTransaction();
            sess.delete(userItem);
            tx.commit();
            return true;
        } catch (Exception e)
        {
            log.warn("Failed to delete user item: " + userItem);
            if (tx != null)
                tx.rollback();
        } finally
        {
            sess.close();
        }
        return false;
    }

    @Override
    public boolean updateUserItem(UserItemStock userItem)
    {
        log.trace("Updating user item");
        log.trace(" > " + userItem);
        Session sess = hiberUtil.getSession();
        Transaction tx = null;
        try
        {
            tx = sess.beginTransaction();
            sess.update(userItem);
            tx.commit();
            return true;
        } catch (Exception e)
        {
            log.warn("Failed to update user item: " + userItem);
            if (tx != null)
                tx.rollback();
        } finally
        {
            sess.close();
        }
        return false;
    }
}
