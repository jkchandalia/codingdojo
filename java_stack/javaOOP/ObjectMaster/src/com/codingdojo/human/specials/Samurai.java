package com.codingdojo.human.specials;
import com.codingdojo.human.Human;
public class Samurai extends Human{
	private static int counter = 0;
	public Samurai() {
		health = 200;
		counter += 1;
	}
	
	public void deathBlow(Human h) {
		h.health = 0;
		health = health/2;
	}
	
	public void meditate() {
		health = 200;
	}
	public static int howMany() {
		return counter;
	}
	

}
