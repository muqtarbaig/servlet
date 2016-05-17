package org.sample.exception;

public class Main {

	public void check() throws ProgramException {
		throw new ProgramException();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.check();
	}
}
