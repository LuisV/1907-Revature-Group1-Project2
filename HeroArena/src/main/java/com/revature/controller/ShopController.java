package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Gladiator;
import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserItemStock;
import com.revature.beans.Character;
import com.revature.services.CharacterService;
import com.revature.services.GladiatorService;
import com.revature.services.ItemService;
import com.revature.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@Controller
@CrossOrigin
@ResponseBody
public class ShopController
{
    private Logger log = Logger.getLogger(ShopController.class);
    private ObjectMapper objMap = new ObjectMapper();
    @Autowired
    private ItemService itemServ;
    @Autowired
    private CharacterService charServ;
    @Autowired
    private GladiatorService gladServ;

    @PutMapping(value="/shop/items/{item}")
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

    @GetMapping(value="/shop/items")
    public ResponseEntity<Set<Item>> getAvailableItems()
    {
        return ResponseEntity.ok(itemServ.getAllItems());
    }

    @PutMapping(value="/shop/gladiator",
				produces="application/json")
    public ResponseEntity<String> purchaseGladiator(HttpSession session)
    {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return ResponseEntity.status(403).build();

        Character charr = charServ.getRandomCharacter();
        Gladiator glad = gladServ.createGladiatorFromCharacter(charr, user);
        if (!gladServ.addGladiator(glad))
            return ResponseEntity.status(500).build();

        StringBuilder sb = new StringBuilder("{\"type\": ");
        try
        {
            sb.append(objMap.writeValueAsString(charr));
            sb.append(", \"gladiator\": ");
            sb.append(objMap.writeValueAsString(glad));
            sb.append("}");
        }
        catch (IOException e)
        {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(sb.toString());
    }
}
