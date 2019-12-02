package com.codingdojo.mammal.bat;
import com.codingdojo.mammal.Mammal;

public class Bat extends Mammal{
	public Bat() {energyLevel = 300;}
	public void fly() {
		System.out.println("Whoosh!");
		energyLevel -= 50;
	}
	public void eatHumans() {
		System.out.println("Nom-nom, yummy Humans!");
		energyLevel += 25;
	}
	public void attackTown() {
		System.out.println("Fire, whoosh!");
		energyLevel -= 100;
	}
	
}
