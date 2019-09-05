package com.revature.data;

import com.revature.beans.Item;
import com.revature.beans.User;
import java.util.List;

public interface ItemDAO
{
    Integer addItem(Item item);
    Item getItemById(int id);
    //List<Item> getItemsByUser(User user);
    void deleteItem(Item item);
    void updateItem(Item item);
}
