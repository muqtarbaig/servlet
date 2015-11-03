package org.sample.controller;

import org.sample.vo.AccessRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

	@RequestMapping(value="/access",method = RequestMethod.POST)
	public String authorizeAccess(@RequestBody @ModelAttribute AccessRequest request){
		if(request.getName().contains("muqtar"))
			return "Authorized";
		return "UnAuthorized !!";
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
