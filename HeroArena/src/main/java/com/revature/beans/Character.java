package com.revature.beans;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table
public class Character {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="character")
    @SequenceGenerator(name="character", sequenceName="character_seq", allocationSize=1)
    private Integer id;
    private String name;
    private String description;
    @Column(name="base_strength")
    private Integer strength;
    @Column(name="base_dexterity")
    private Integer dexterity;
    @Column(name="base_vitality")
    private Integer vitality;
    @Column(name="base_health")
    private Integer currentHealth;
    private String rarity;

    public Character() {
    }

    public Character(String name, String description, Integer strength, Integer dexterity, Integer vitality, Integer currentHealth, String rarity) {
        this.name = name;
        this.description = description;
        this.strength = strength;
        this.dexterity = dexterity;
        this.vitality = vitality;
        this.currentHealth = currentHealth;
        this.rarity = rarity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(Integer currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) &&
                Objects.equals(rarity, character.rarity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, rarity);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", vitality=" + vitality +
                ", currentHealth=" + currentHealth +
                ", rarity='" + rarity + '\'' +
                '}';
    }
}
