package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

public class Player extends User{
	private Set<Gladiator> roster;

	public Player() {
		super();
		roster = new HashSet<Gladiator>();
	}

	public Player(Integer id, String username, String password) {
		super(id, username, password);
		roster = new HashSet<Gladiator>();
	}

	public Player(int i) {
		super(i);
	}
	
}
