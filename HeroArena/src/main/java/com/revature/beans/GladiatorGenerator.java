package com.revature.beans;

import java.util.Random;

public class GladiatorGenerator {
	private static GladiatorGenerator gg = null;
	private static Random r;
	private GladiatorGenerator() {
		r = new Random();
	}
	public static GladiatorGenerator getGladiatorGenerator(int stars) {
		if (gg == null)
			gg = new GladiatorGenerator();
		return gg;
	}

	public static Gladiator generateGladiator(String name, int star) {
		int strength = 0, dexterity = 0, vitality = 0;
		int numberOfPoints = 6 + 2 * star;
		int selection = 0;
		while (numberOfPoints > 0) {
			selection = r.nextInt(3);
			switch (selection) {
			case 0: strength++; break;
			case 1: dexterity++; break;
			case 2: vitality++; break;
			default:
			}
			numberOfPoints--;
		}
		Gladiator g = new Gladiator(name, strength, dexterity, vitality);
		return g;
	}
}
