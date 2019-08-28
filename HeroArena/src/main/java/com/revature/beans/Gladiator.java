package com.revature.beans;

public class Gladiator {
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
	
	
	
}
