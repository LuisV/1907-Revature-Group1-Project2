package com.revature.data.hibernate;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.data.ItemDAO;
import com.revature.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemHibernate implements ItemDAO
{
    private Logger log = Logger.getLogger(ItemHibernate.class);

    @Autowired
    private HibernateUtil hiberUtil;

    @Override
    public Integer addItem(Item item)
    {
        log.trace("Adding new item to database");
        log.trace(" > " + item);

        Integer id = null;
        Session sess = hiberUtil.getSession();
        Transaction tx = null;
        try
        {
            tx = sess.beginTransaction();
            id = (Integer) sess.save(item);
            tx.commit();
            log.trace(" > Item successfully added!");
        } catch (Exception e)
        {
            log.warn("Failed to add item to database");
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally
        {
            sess.close();
        }

        return id;
    }

    @Override
    public Item getItemById(int id)
    {
        log.trace("Getting item by id (id = " + id + ")");
        Session sess = hiberUtil.getSession();
        Item item = (Item) sess.get(Item.class, id);
        sess.close();

        return item;
    }

    //@Override
    //public List<Item> getItemsByUser(User user)
    //{
    //    log.trace("Getting all items by user");
    //    log.trace(" > " + user);
    //    Session sess = hiberUtil.getSession();

    //    User tempUser = sess.get(User.class, user.getId());
    //    sess.close();

    //    List<Item> result;
    //    if (tempUser == null)
    //    {
    //        log.warn("Provided user does not exist in database.");
    //        result = new ArrayList<Item>();
    //    }
    //    else
    //        result = tempUser.getItems();

    //    user.setItems(result);

    //    return result;
    //}

    @Override
    public void deleteItem(Item item)
    {
        log.trace("Deleting item");
        log.trace(" > " + item);
        Session sess = hiberUtil.getSession();
        Transaction tx = null;
        try
        {
            tx = sess.beginTransaction();
            sess.delete(item);
            tx.commit();
        } catch (Exception e)
        {
            log.warn("Failed to delete item: " + item);
            if (tx != null)
                tx.rollback();
        } finally
        {
            sess.close();
        }
    }

    @Override
    public void updateItem(Item item)
    {
        log.trace("Updating item");
        log.trace(" > " + item);
        Session sess = hiberUtil.getSession();
        Transaction tx = null;
        try
        {
            tx = sess.beginTransaction();
            sess.update(item);
            tx.commit();
        } catch (Exception e)
        {
            log.warn("Failed to update item: " + item);
            if (tx != null)
                tx.rollback();
        } finally
        {
            sess.close();
        }
    }
}
