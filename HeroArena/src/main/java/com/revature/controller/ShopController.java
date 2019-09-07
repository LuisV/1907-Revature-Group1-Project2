package com.revature.controller;

import com.revature.beans.Gladiator;
import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserItemStock;
import com.revature.services.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
@ResponseBody
public class ShopController
{
    private Logger log = Logger.getLogger(ShopController.class);
    @Autowired
    private ItemService itemServ;

    @PostMapping(value="/shop/items/{item}")
    public ResponseEntity<UserItemStock> purchaseItem(@PathVariable("item") Integer itemId, HttpSession session)
    {
        log.trace("Attempting to purchase an item.");
        User user = (User) session.getAttribute("user");
        if (user == null)
            return ResponseEntity.status(403).build();

        Item item;
        if (itemId == null || null == (item = itemServ.getItemById(itemId)))
        {
            log.trace(" > Specified item not found.");
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(itemServ.addToInventory(user, item, 1));
    }


}
