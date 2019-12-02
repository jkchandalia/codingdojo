package com.codingdojo.mammal.gorilla;
import com.codingdojo.mammal.Mammal;
class Gorilla extends Mammal{
    public void throwSomething() {
        System.out.println("Throwing something!");
        energyLevel -= 5;
    }
    public void eatBananas() {
        System.out.println("Eating bananas!");
        energyLevel += 10;
    }
    public void climb() {
        System.out.println("Climbing tree!");
        energyLevel -= 10;
    }
}