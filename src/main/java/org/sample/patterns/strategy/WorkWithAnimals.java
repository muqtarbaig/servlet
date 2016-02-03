package org.sample.patterns.strategy;

public class WorkWithAnimals {

	public static void main(String[] args) {
		
		Animal dog = new Dog();
		dog.setName("Marcus");
		System.out.println(dog.getName() + " "+dog.getSound());
		System.out.println(dog.tryToFly());
		
		Animal bird = new Bird();
		bird.setName("Parry");
		System.out.println(bird.getName() + " "+bird.getSound());
		System.out.println(bird.tryToFly());
		
/*		Dog fido = new Dog();
		fido.setName("Fido");
		fido.setWeight(-1);
		System.out.println(fido.tryToFly());
		
*/
		
	}
}
