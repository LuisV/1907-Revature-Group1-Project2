package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.revature.beans.User;
import com.revature.services.UserService;

@CrossOrigin
@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	private UserService us;

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public User goLogin(HttpSession session) {
		User u = (User) session.getAttribute("user");
		if(u == null)
			return null;
		return u;
	}

	@ResponseBody
	@PostMapping
	public User login(String username, String password, HttpSession session) {
		System.out.println(username+"/"+password);
		User u = us.login(username, password);
		if(u == null)
			return null;
		session.setAttribute("user", u);
		return u;
	}

}
