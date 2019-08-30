package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="player")
@PrimaryKeyJoinColumn(name="id")
public class Player extends User{
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	
	private Set<Gladiator> roster;

	public Player() {
		super();
		roster = new HashSet<Gladiator>();
	}

	public Player(Integer id, String username, String password) {
		super(id, username, password, 1);
		roster = new HashSet<Gladiator>();
	}

	public Player(int i) {
		super(i);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((roster == null) ? 0 : roster.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (roster == null) {
			if (other.roster != null)
				return false;
		} else if (!roster.equals(other.roster))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [roster=" + roster + "]";
	}
	
	
}
