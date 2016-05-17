package org.sample.abstractclass;

public class AbstractMain {

	
	public static void main(String[] args) {
//		new AbstractImpl().nonAbstract();
		
		String text = " hello  world     this";
		System.out.println(text.replaceAll("\\s+", " "));
	}
}
