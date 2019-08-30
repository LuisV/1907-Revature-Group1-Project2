package com.revature.beans;

import java.util.Random;

import org.apache.log4j.Logger;

import com.revature.utils.LogUtil;

public class GladiatorGenerator {
	private static GladiatorGenerator gg = null;
	private static Logger log;
	private static Random r;
	{
		// this doesn't work, safe to delete
		// pretty sure the singleton is not the best use
		r = new Random();
		log = Logger.getLogger(GladiatorGenerator.class);
	}
	public static GladiatorGenerator getGladiatorGenerator() {
		if (gg == null) {
			gg = new GladiatorGenerator();
		}
		return gg;
	}

	public static Gladiator generateGladiator(String name, int star) {
		int strength = 0, dexterity = 0, vitality = 0;
		int numberOfPoints = 6 + 2 * star;
		int selection = 0;
		if (r == null) r = new Random();
		if (log == null) log = Logger.getLogger(GladiatorGenerator.class);
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
		log.trace(g);
		return g;
	}
}
