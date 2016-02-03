package org.sample.patterns.strategy;

import org.sample.patterns.strategy.fly.Canfly;

public class Bird extends Animal{

	public Bird() {
		setSound("Twee...tss");
		flyType = new Canfly();
	}
}
