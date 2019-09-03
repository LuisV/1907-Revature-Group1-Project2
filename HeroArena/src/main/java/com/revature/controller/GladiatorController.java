package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Gladiator;
import com.revature.beans.User;
import com.revature.data.GladiatorDAO;
import com.revature.data.UserDAO;

@Controller
@CrossOrigin
@RequestMapping(value="/gladiator")
public class GladiatorController {
	
	@Autowired
	private GladiatorDAO gd;
	@Autowired
	private UserDAO ud;
	
	@GetMapping("{play}")
	@ResponseBody
	public Set<Gladiator> getGladiatorsByUser(@PathVariable("play") Integer id) {
		User u = ud.getUser(id);
		System.out.println(u);
		return gd.getGladiatorsForUser(u);
	}
}
