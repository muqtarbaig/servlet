package org.sample.service;

import org.springframework.stereotype.Component;

@Component
public class VeteranValidator implements AgeValidator {

	@Override
	public boolean validate(int age) {

		if(age >= 50) return true;
		
		return false;
	}

}
