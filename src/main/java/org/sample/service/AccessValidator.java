package org.sample.service;

import javax.annotation.Resource;

import org.sample.vo.AccessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccessValidator {

	//@Autowired
	//@Qualifier(value = "validator")
	@Resource(name = "validator")
	private AgeValidator ageValidator;
	
	@Autowired
	private VeteranValidator veteranValidator;
	
	private static final Logger fileLogger = LoggerFactory.getLogger("EventLogger");
	
	public boolean validateAccess(AccessRequest req){
		fileLogger.info("validateAccess Method\n");
		if(ageValidator.validate(req.getAge())) return true;
		return false;
	}
	
	public boolean validateVetern(AccessRequest req){
		fileLogger.info("validateVetern Method\n");
		if(veteranValidator.validate(req.getAge())) return true;
		return false;
	}
}
