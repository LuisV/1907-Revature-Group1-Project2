package com.revature.controller;

import java.util.Set;

import com.revature.beans.Item;
import com.revature.beans.UserItemStock;
import com.revature.services.GladiatorService;
import com.revature.services.ItemService;
import com.revature.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.Gladiator;
import com.revature.beans.User;

import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userServ;
	@Autowired
	private GladiatorService gladServ;
	@Autowired
	private ItemService itemServ;
	private Logger log = Logger.getLogger(UserController.class);
	
	@GetMapping(value="/user/roster/{play}")
	public Set<Gladiator> getRoster(@PathVariable("play") Integer id) {
		System.out.println("getRoster in UserController");
		return gladServ.getGladiatorsByUser(id);
	}

	@GetMapping(value="/user/items")
	public ResponseEntity<Set<UserItemStock>> getItems(HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if (user == null)
		    return ResponseEntity.status(403).build();

		log.trace("Getting items for user '" + user.getUsername() + "'");
		Set<UserItemStock> items = itemServ.getItemsOfUser(user);

		return ResponseEntity.ok(items);
	}

	@PutMapping(value="/user/items/{item}")
	public ResponseEntity<Gladiator> useItem(@PathVariable("item") Integer itemId, @RequestParam Integer gladiatorId, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if (user == null)
			return ResponseEntity.status(403).build();

		log.trace("Attempting to use an item");

		Gladiator glad = gladServ.getGladiatorById(gladiatorId);
		if (glad == null || itemId == null)
		{
			log.trace(" > Specified target gladiator not found");
			return ResponseEntity.status(400).build();
		}

		Item item = itemServ.getItemById(itemId);
		if (item == null)
		{
			log.trace(" > Specified item not found");
			return ResponseEntity.status(400).build();
		}

		itemServ.useItem(user, item, glad);
		return ResponseEntity.ok(glad);
	}
}
