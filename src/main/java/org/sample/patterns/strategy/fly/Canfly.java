package org.sample.patterns.strategy.fly;

public class Canfly implements IFly {

	@Override
	public String fly(String animalName) {
		return animalName+" is flying High";
	}

}
