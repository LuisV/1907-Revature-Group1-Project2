package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

public class Player extends User{
	private Set<Gladiator> roster;

	public Player() {
		super();
		roster = new HashSet<Gladiator>();
	}

	public Player(String username, String password) {
		super(username, password);
		roster = new HashSet<Gladiator>();
	}
	
}
