package com.revature.services;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Gladiator;

import com.revature.data.GladiatorDAO;

import java.util.Set;

@Service
public class GladiatorService {
	@Autowired
	private GladiatorDAO gd;
	@Autowired
	private UserDAO ud;

	public Set<Gladiator> getGladiatorByUser( Integer id){
		User u = ud.getUser(id);
		return gd.getGladiatorsForUser(u);
	};

	public Set<Gladiator> getAllGladiators(){
		return gd.getAllGladiators();
	}
	
	public Gladiator updateGladiator(Gladiator g) {
		System.out.println("calling updateGladiator in GladiatorService");
		gd.updateGladiator(g);
		return g;
	}
}
