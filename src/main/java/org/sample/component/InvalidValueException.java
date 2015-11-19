package org.sample.component;

public class InvalidValueException extends RuntimeException {

	public InvalidValueException(String string) {
		super(string);
		System.out.println("IVE constructor");
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
