package com.codingdojo.human;

public class Human {
	public int stealth = 3;
	public int strength = 3;
	public int intelligence = 3;
	public int health = 100;
	public void attack(Human h) {
		h.health -= strength;
	}
	public void displayHealth() {
		System.out.println("Health: "+health);
	}

}
