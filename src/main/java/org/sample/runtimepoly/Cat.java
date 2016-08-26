package org.sample.runtimepoly;

public class Cat extends Animal{

	@Override
	public void printName() {
		System.out.println("This is cat");
	}
	
	public void catJob() {
		System.out.println("Meoww");
	}
}
