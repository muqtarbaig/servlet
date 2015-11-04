package org.sample.controller;

import org.sample.service.AccessValidator;
import org.sample.vo.AccessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

	@Autowired
	private AccessValidator accessValidator;
	
	@RequestMapping(value="/access",method = RequestMethod.POST)
	public String authorizeAccess(@RequestBody AccessRequest request){
		if(accessValidator.validateAccess(request))
			return "Young";
		if(accessValidator.validateVetern(request))
		return "Veteran";
		return "Kid";
	} 
	
	
	@RequestMapping(value="/sampleAccess")
	public ResponseEntity<AccessRequest> getSample(){
		AccessRequest req = new AccessRequest();
		req.setAge(25);
		req.setCountry("Dubai");
		req.setName("Muqtar");
		
		return new ResponseEntity<AccessRequest>(req,HttpStatus.OK);
		
	}
}
