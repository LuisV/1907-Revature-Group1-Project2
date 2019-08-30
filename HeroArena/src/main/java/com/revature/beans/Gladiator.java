package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Gladiator {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gladiator")
	private Integer id;
	private String name;
	private Integer strength;
	private Integer dexterity;
	private Integer vitality;
	private Integer experience;
	private Integer level;
	private Integer currentHealth;
	private Integer maxHealth;
	
	public Gladiator() {
		super();
		this.name = "no-arg";
		this.strength = 2;
		this.dexterity = 2;
		this.vitality = 0;
		this.experience = 0;
		this.level = 1;
		this.maxHealth = 5;
		this.currentHealth = this.maxHealth;
	}
	
	public Gladiator(Integer strength, Integer dexterity, Integer vitality) {
		super();
		this.name = "str/dex/vit";
		this.strength = 2 + strength;
		this.dexterity = 2 + dexterity;
		this.vitality = vitality;
		this.maxHealth = 5 + (2*vitality);
		this.currentHealth = this.maxHealth;
		this.experience = 0;
		
	}

	public Gladiator(String name, Integer strength, Integer dexterity, Integer vitality) {
		super();
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.vitality = vitality;
	}

	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public Integer getDexterity() {
		return dexterity;
	}
	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}
	public Integer getVitality() {
		return vitality;
	}
	public void setVitality(Integer vitality) {
		this.vitality = vitality;
		reconfigureHealth();
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public void reconfigureHealth() {
		this.maxHealth = 5 + (2*vitality);
	}

	public Integer getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(Integer currentHealth) {
		this.currentHealth = currentHealth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentHealth == null) ? 0 : currentHealth.hashCode());
		result = prime * result + ((dexterity == null) ? 0 : dexterity.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((maxHealth == null) ? 0 : maxHealth.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((strength == null) ? 0 : strength.hashCode());
		result = prime * result + ((vitality == null) ? 0 : vitality.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gladiator other = (Gladiator) obj;
		if (currentHealth == null) {
			if (other.currentHealth != null)
				return false;
		} else if (!currentHealth.equals(other.currentHealth))
			return false;
		if (dexterity == null) {
			if (other.dexterity != null)
				return false;
		} else if (!dexterity.equals(other.dexterity))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (maxHealth == null) {
			if (other.maxHealth != null)
				return false;
		} else if (!maxHealth.equals(other.maxHealth))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strength == null) {
			if (other.strength != null)
				return false;
		} else if (!strength.equals(other.strength))
			return false;
		if (vitality == null) {
			if (other.vitality != null)
				return false;
		} else if (!vitality.equals(other.vitality))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gladiator [id=" + id + ", name=" + name + ", strength=" + strength + ", dexterity=" + dexterity
				+ ", vitality=" + vitality + ", experience=" + experience + ", level=" + level + ", currentHealth="
				+ currentHealth + ", maxHealth=" + maxHealth + "]";
	}
	
	
	
}
