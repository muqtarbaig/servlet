package org.sample.controller;

import org.sample.exception.ProgramException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SampleExceptionController {

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException rex) {
		System.out.println("Runtime exception " + rex.getMessage());
		return rex.getMessage();
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ProgramException.class)
	public String handleSQLException(ProgramException ex) {
		System.out.println("Program exception");
		return String.format("error_code : %s from system %s with message %s",ex.getErrorCode(),ex.getErrorSystem(), ex.getMessage());
	}
	
}
