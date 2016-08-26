package org.sample.service;

import org.springframework.stereotype.Component;

@Component("ageValid")
public class AgeValidatorImpl implements AgeValidator {

	@Override
	public boolean validate(int age) {

		if(age>=10 && age <50)
		return true;
		return false;
	}

}
