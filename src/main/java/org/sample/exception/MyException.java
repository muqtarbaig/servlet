package org.sample.exception;

public class MyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyException(String server, String message) {
		super(message);
		System.out.println("Issue in "+server);
	}

	
}
