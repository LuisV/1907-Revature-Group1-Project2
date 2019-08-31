package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Gladiator;

import com.revature.data.GladiatorDAO;

@Service
public class GladiatorService {
	//@Autowired
	private GladiatorDAO gd;
	public Gladiator getGladiator() {
		return null;
	}
	@Autowired
	private GladiatorDAO gd;
	
}
