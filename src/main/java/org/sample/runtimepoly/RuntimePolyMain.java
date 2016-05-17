package org.sample.runtimepoly;

public class RuntimePolyMain {

	public static void main(String[] args) {
		Animal animal = new Animal();
		Animal cat = new Cat();
		Animal hen = new Hen();
		
		animal.printName();
		cat.printName();
		hen.printName();
		
	}
	
}
