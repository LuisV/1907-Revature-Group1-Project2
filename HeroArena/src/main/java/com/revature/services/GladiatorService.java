package com.revature.services;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Gladiator;
import com.revature.beans.Character;

import com.revature.data.GladiatorDAO;

import java.util.Set;

@Service
public class GladiatorService {
	@Autowired
	private GladiatorDAO gd;
	@Autowired
	private UserDAO ud;

	public Gladiator createGladiatorFromCharacter(Character charr, User owner)
	{
		Gladiator glad = new Gladiator();
		glad.setName(charr.getName());
		glad.setStrength(charr.getStrength());
		glad.setDexterity(charr.getDexterity());
		glad.setVitality(charr.getVitality());
		glad.setLevel(1);
		glad.setMaxHealth(charr.getCurrentHealth());
		glad.setCurrentHealth(charr.getCurrentHealth());
		glad.setExperience(0);
		glad.setPlayer(owner);

		return glad;
	}

	public boolean addGladiator(Gladiator glad)
	{
	    return (gd.addGladiator(glad) != null);
	}

	public Gladiator getGladiatorById(Integer id)
	{
		return gd.getGladiator(id);
	}

	public Set<Gladiator> getGladiatorsByUser( Integer id){
		User u = ud.getUser(id);
		return gd.getGladiatorsForUser(u);
	};

	public Set<Gladiator> getAllGladiatorsNotOwnedBy(User user)
	{
		return gd.getGladiatorsNotOwnedBy(user);
	}

	public Set<Gladiator> getAllGladiators(){
		return gd.getAllGladiators();
	}
	
	public Gladiator updateGladiator(Gladiator g) {
		System.out.println("calling updateGladiator in GladiatorService");
		gd.updateGladiator(g);
		return g;
	}
}
