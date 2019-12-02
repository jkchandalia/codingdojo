package com.codingdojo.human;

public class HumanTest {
	public static void main(String[] args) {
		Human h1 = new Human();
		Human h2 = new Human();
		h2.attack(h1);
		System.out.println(h2.health);
		System.out.println(h1.health);
	}

}
