package com.codingdojo.human.specials;
import com.codingdojo.human.Human;
public class Ninja extends Human{
	public Ninja() {
		stealth = 10;
	}
	public void steal(Human h) {
		h.health -= stealth;
		health += stealth;
	}
	public void runAway() {
		health -= 10;
	}

}
