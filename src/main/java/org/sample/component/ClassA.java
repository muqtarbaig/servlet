package org.sample.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassA {

	static Logger logger = LoggerFactory.getLogger(ClassA.class);
	public void doA(){
		
		System.out.println("Doing A");
		for(int i=0;i<10;i++){
			System.out.println("value of i : "+i);
			if(i==5){
				System.out.println("why i is 5 ; throwing exception");
				throw new InvalidValueException("i value is 5 exception");
			}
		}
	}
	
	public static void main(String[] args) {
		try{
		ClassA a = new ClassA();
		a.doA();
		}catch(Exception e){
			logger.error("error occured ",e);
//		System.out.println("Exception while doing A" +e);
		}
	}
}
