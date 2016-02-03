package org.sample.component;

public class TestOverriding {
	public static void main(String aga[]){
		Parrot bird=new Parrot();
		//bird.fly();
	}
}
class Bird{
	 private  void fly(){
		System.out.println("Bird is flying");
	}
}
class Parrot extends Bird{
	public void doStuff(){
		System.out.println("I am parrot , and I am doing stuff");
	}
}