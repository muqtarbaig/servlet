package org.sample.exception;

public class ProgramException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6339243266953889518L;

	private String errorSystem;
	private int errorCode;
	
	public ProgramException(int code, String system, String message) {
		super(message);
		this.errorCode = code;
		this.errorSystem = system;
		
	}

	public String getErrorSystem() {
		return errorSystem;
	}

	public void setErrorSystem(String errorSystem) {
		this.errorSystem = errorSystem;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
