package org.sample.patterns.strategy.fly;

public class CantFly implements IFly {

	@Override
	public String fly(String animalName) {
		return animalName+" cannot fly";
	}

}
