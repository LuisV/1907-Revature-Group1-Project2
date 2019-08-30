package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Gladiator;
import com.revature.beans.GladiatorGenerator;

@Controller
@CrossOrigin
@RequestMapping(value="/gladiator/generate")
public class GladiatorGeneratorController {
	private GladiatorGenerator gg;
	{
		gg = new GladiatorGenerator();
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Gladiator generateGladiator(HttpSession session) {
		Integer star = 4;
		
		return GladiatorGenerator.generateGladiator("Testgladiator", star);
	}
	
	
}
