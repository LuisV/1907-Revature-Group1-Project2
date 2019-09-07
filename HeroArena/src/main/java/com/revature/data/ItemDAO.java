package com.revature.data;

import com.revature.beans.Item;
import com.revature.beans.User;
import java.util.List;
import java.util.Set;

public interface ItemDAO
{
    Integer addItem(Item item);
    Item getItemById(int id);
    Set<Item> getAllItems();
    boolean deleteItem(Item item);
    boolean updateItem(Item item);
}
