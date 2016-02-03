package org.sample.patterns.strategy;

import org.sample.patterns.strategy.fly.IFly;

public class Animal {

	private int weight;
	private int height;
	private String name;
	private String sound;
	
	protected IFly flyType;
	

	public void setSound(String sound){this.sound = sound;}
	public String getSound(){return sound;}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight > 0)
		this.weight = weight;
		else System.out.println("Weight must be > 0 ");
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// Following Strategy pattern
	public String tryToFly() {
		return flyType.fly(name);
	}
	public void setFlyType(IFly flyType) {
		this.flyType = flyType;
	}
	public void methodOfAnimal(){
		
	}
	
	
}
