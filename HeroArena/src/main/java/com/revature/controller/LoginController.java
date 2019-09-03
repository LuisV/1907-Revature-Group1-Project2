package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;

import com.revature.beans.User;
import com.revature.services.UserService;

@Controller
@CrossOrigin
public class LoginController {

	@Autowired
	private UserService us;

	@ResponseBody
	@GetMapping(value="/login")
	public User goLogin(HttpSession session) {
		User u = (User) session.getAttribute("user");
		if(u == null)
			return null;
		return u;
	}

	@ResponseBody
	@PostMapping(value="/login")
	public User login(String username, String password, HttpSession session) {
		System.out.println(username+"/"+password);
		User u = us.login(username, password);
		if(u == null)
			return null;
		session.setAttribute("user", u);
		return u;
	}

	@ResponseBody
	@PostMapping(value="/register")
	public User register(String username, String password, HttpSession session)
	{
		User u = us.registerUser(username, password);
		if(u == null)
			return null;
		session.setAttribute("user", u);
		return u;
	}
}
