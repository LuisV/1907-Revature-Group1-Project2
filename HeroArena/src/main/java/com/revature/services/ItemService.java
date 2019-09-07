package com.revature.services;

import com.revature.beans.Gladiator;
import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserItemStock;
import com.revature.data.GladiatorDAO;
import com.revature.data.ItemDAO;
import com.revature.data.UserItemsDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ItemService
{
    private Logger log = Logger.getLogger(ItemService.class);
    @Autowired
    private UserItemsDAO invDao;
    @Autowired
    private ItemDAO itemDao;
    @Autowired
    private GladiatorDAO gladDao;

    //////////////////////////////////////////////
    // Player-oriented item methods
    //////////////////////////////////////////////

    public Item getItemById(Integer id)
    {
        return itemDao.getItemById(id);
    }

    public Set<UserItemStock> getItemsOfUser(User user)
    {
        Set<UserItemStock> results = invDao.getUserItemsByUser(user);
        if (results == null)
            results = new HashSet<UserItemStock>();

        return results;
    }

    public void useItem(User user, Item item, Gladiator target)
    {
        log.trace("User is using an item on a gladiator");
        log.trace(" > user=" + user + ", item=" + item + ", target=" + target);
        // Grab user's current item stock from DB
        UserItemStock available = invDao.getUserItemById(item, user);

        if (available != null)
        {
            int amount = available.getAmount();
            if (amount < 1)
            {
                log.warn("Inventory item exists with amount less than one!");
                invDao.deleteUserItem(available);
                return;
            }

            log.trace(" > Verified that user owns " + amount + " of the item.");

            item = available.getItem();
            boolean isSuccess;

            // Attempt to adjust amount of item owned by user
            if (amount > 1)
            {
                available.setAmount(amount - 1);
                isSuccess = invDao.updateUserItem(available);
            }
            else
            {
                isSuccess = invDao.deleteUserItem(available);
            }

            // Apply item effects to target gladiator
            if (isSuccess)
            {
                int maxHealth = target.getMaxHealth();
                int health = target.getCurrentHealth() + Math.round(maxHealth * (item.getHealthOffset() / 100.0f));
                health = Math.min(maxHealth, health);

                target.setCurrentHealth(health);
                gladDao.updateGladiator(target);
                // TODO: Add check to see if update was successful and revert health if update failed.
            }
        }
    }

    // Always returns a UserItemStock. If failed, returns previous item stock if player
    // owns any of the item.  Otherwise, returns a UserItemStock with a negative amount.
    public UserItemStock addToInventory(User user, Item item, int amount)
    {
        log.trace("Adding item to user's inventory");
        log.trace(" > user=" + user + ", item=" + item + ", amount=" + amount);

        // Grab user's current item stock from DB
        UserItemStock available = invDao.getUserItemById(item, user);

        if (available != null)
        {
            int prevAmount = available.getAmount();
            if (prevAmount < 1)
            {
                log.warn("Inventory item exists with amount less than one!");
                available.setAmount(0);
            }

            log.trace(" > Verified that user already owns " + prevAmount + " of the item.");

            available.setAmount(prevAmount + amount);
            if (invDao.updateUserItem(available))
                log.trace(" > Item amount successfully updated");
            else
            {
                log.trace(" > Failed to update item amount");
                available.setAmount(prevAmount);
            }
        }
        else
        {
            available = invDao.addUserItem(item, user);
            if (available == null)
            {
                log.trace(" > Failed to add new item to user's inventory");
                available = new UserItemStock();
                available.setItem(item);
                available.setUser(user);
                available.setAmount(-1);
            }
        }

        return available;
    }

    //////////////////////////////////////////////
    // Admin-oriented item methods
    //////////////////////////////////////////////

    public Item addNewItem(Item item)
    {
        Integer key = itemDao.addItem(item);
        if (key == null)
            return null;

        item.setId(key);

        return item;
    }

    public Item modifyItem(Item item)
    {
        if (!itemDao.updateItem(item))
            return null;

        return item;
    }
}
