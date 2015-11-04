package org.sample.service;

import org.sample.vo.AccessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccessValidator {

	@Autowired(required = false)
	@Qualifier(value = "validator")
	private AgeValidator ageValidator;
	
	@Autowired
	private VeteranValidator veteranValidator;
	
	public boolean validateAccess(AccessRequest req){
		if(ageValidator.validate(req.getAge())) return true;
		return false;
	}
	
	public boolean validateVetern(AccessRequest req){
		if(veteranValidator.validate(req.getAge())) return true;
		return false;
	}
}
