package org.sample.patterns.strategy;

import org.sample.patterns.strategy.fly.CantFly;

public class Dog extends  Animal{

	
	public Dog(){
		setSound("bark...zz");
		flyType = new CantFly();
	}

	public void digHole(){
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Dog Object :: "; 
	}
}
