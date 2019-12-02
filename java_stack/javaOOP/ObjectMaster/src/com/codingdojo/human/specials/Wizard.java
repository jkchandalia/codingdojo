package com.codingdojo.human.specials;
import com.codingdojo.human.Human;
public class Wizard extends Human{
	public Wizard() {
		health = 50;
		intelligence = 8;
	}
	public void heal(Human h) {
		h.health += intelligence;
	}
	public void fireball(Human h) {
		h.health -= 3*intelligence;
	}

}
