package com.revature.beans;

import javax.persistence.*;

@Entity
@Table
public class Gladiator {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gladiator")
	@SequenceGenerator(name="gladiator", sequenceName="gladiator_seq", allocationSize=1)
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="player_id")
	private User player;
	private String name;
	private Integer strength;
	private Integer dexterity;
	private Integer vitality;
	private Integer experience;
	@Column(name="current_level")
	private Integer level;
	@Column(name="current_health")
	private Integer currentHealth;
	@Column(name="max_health")
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
		this.reconfigureHealth();

	}
	
	public Gladiator(Integer strength, Integer dexterity, Integer vitality) {
		this();
		this.name = "str/dex/vit";
		this.strength = 2 + strength;
		this.dexterity = 2 + dexterity;
		this.vitality = vitality;
		this.maxHealth = 5 + (2*vitality);
		this.currentHealth = this.maxHealth;
		this.experience = 0;
		this.reconfigureHealth();

	}

	public Gladiator(String name, Integer strength, Integer dexterity, Integer vitality) {
		this(strength, dexterity, vitality);
		this.name = name;
		//this.strength = strength;
		//this.dexterity = dexterity;
		//this.vitality = vitality;
		this.reconfigureHealth();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getPlayer()
	{
		return player;
	}

	public void setPlayer(User player)
	{
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(Integer maxHealth) {
		this.maxHealth = maxHealth;
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
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Gladiator gladiator = (Gladiator) o;

		if (id != null ? !id.equals(gladiator.id) : gladiator.id != null) return false;
		//if (player != null ? !player.equals(gladiator.player) : gladiator.player != null) return false;
		if (name != null ? !name.equals(gladiator.name) : gladiator.name != null) return false;
		if (strength != null ? !strength.equals(gladiator.strength) : gladiator.strength != null) return false;
		if (dexterity != null ? !dexterity.equals(gladiator.dexterity) : gladiator.dexterity != null) return false;
		if (vitality != null ? !vitality.equals(gladiator.vitality) : gladiator.vitality != null) return false;
		if (experience != null ? !experience.equals(gladiator.experience) : gladiator.experience != null) return false;
		if (level != null ? !level.equals(gladiator.level) : gladiator.level != null) return false;
		if (currentHealth != null ? !currentHealth.equals(gladiator.currentHealth) : gladiator.currentHealth != null)
			return false;
		return maxHealth != null ? maxHealth.equals(gladiator.maxHealth) : gladiator.maxHealth == null;
	}

	@Override
	public int hashCode()
	{
		int result = id != null ? id.hashCode() : 0;
		//result = 31 * result + (player != null ? player.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (strength != null ? strength.hashCode() : 0);
		result = 31 * result + (dexterity != null ? dexterity.hashCode() : 0);
		result = 31 * result + (vitality != null ? vitality.hashCode() : 0);
		result = 31 * result + (experience != null ? experience.hashCode() : 0);
		result = 31 * result + (level != null ? level.hashCode() : 0);
		result = 31 * result + (currentHealth != null ? currentHealth.hashCode() : 0);
		result = 31 * result + (maxHealth != null ? maxHealth.hashCode() : 0);
		return result;
	}

	@Override
	public String toString()
	{
		return "Gladiator{" +
				"id=" + id +
				", player_id=" + (player != null ? player.getId() : null) +
				", name='" + name + '\'' +
				", strength=" + strength +
				", dexterity=" + dexterity +
				", vitality=" + vitality +
				", experience=" + experience +
				", level=" + level +
				", currentHealth=" + currentHealth +
				", maxHealth=" + maxHealth +
				'}';
	}
}
