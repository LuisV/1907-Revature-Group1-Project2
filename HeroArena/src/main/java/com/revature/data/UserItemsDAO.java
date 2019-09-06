package com.revature.data;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserItemStock;

import java.util.Set;

public interface UserItemsDAO
{
    UserItemStock addUserItem(Item item, User user);
    UserItemStock getUserItemById(Item item, User user);
    Set<UserItemStock> getUserItemsByUser(User user);
    boolean deleteUserItem(UserItemStock userItem);
    boolean updateUserItem(UserItemStock userItem);
}
