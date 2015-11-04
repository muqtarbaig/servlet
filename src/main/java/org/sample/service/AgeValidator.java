package org.sample.service;

import org.springframework.stereotype.Component;

@Component
public interface AgeValidator {

	public boolean validate(int age);
}
