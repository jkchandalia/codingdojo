package com.codingdojo.human.specials;

public class SpecialsText {
	public static void main(String[] args) {
		Ninja n = new Ninja();
		Samurai s = new Samurai();
		Wizard w = new Wizard();
		Samurai sam = new Samurai();
		System.out.println(Samurai.howMany());
		n.steal(s);
		n.runAway();
		s.deathBlow(n);
		n.displayHealth();
		w.heal(n);
		n.displayHealth();
		w.heal(n);
		n.displayHealth();
		w.fireball(s);
		s.displayHealth();
		s.meditate();
		s.displayHealth();
		
		
	}

}
