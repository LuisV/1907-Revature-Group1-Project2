package com.revature.data.hibernate;

import com.revature.beans.Item;
import com.revature.data.ItemDAO;
import com.revature.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            log.trace(" > Item successfully added! item=" + item);
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

    @Override
    public boolean deleteItem(Item item)
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
            return true;
        } catch (Exception e)
        {
            log.warn("Failed to delete item: " + item);
            if (tx != null)
                tx.rollback();
        } finally
        {
            sess.close();
        }
        return false;
    }

    @Override
    public boolean updateItem(Item item)
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
            return true;
        } catch (Exception e)
        {
            log.warn("Failed to update item: " + item);
            if (tx != null)
                tx.rollback();
        } finally
        {
            sess.close();
        }
        return false;
    }
}
