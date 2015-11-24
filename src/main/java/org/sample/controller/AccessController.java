package org.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.sample.exception.MyException;
import org.sample.service.AccessValidator;
import org.sample.util.EventLogger;
import org.sample.vo.AccessRequest;
import org.sample.vo.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	

	private static final Logger Logger = LoggerFactory.getLogger(AccessController.class);
	private static final Logger fileLogger = LoggerFactory.getLogger("EventLogger");// EventLogger.getLogger();
	
	@RequestMapping(value="/access",method = RequestMethod.POST)
	public String authorizeAccess(@RequestBody AccessRequest request){
		
		Logger.info("Access Request :: "+request);
		fileLogger.info(request.toString()+"\n"); 
		
		if(request.getAge() == 99){
			throw new MyException("Access request age ", "Age is 99");
		}
		
		
		Logger.info("Log the request ");
		//eventLogger.logEvent(request);
		testLog();
		
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
		req.setState("TS");
		req.setName("Muqtar");
		
		List<Channel> clist = new ArrayList<Channel>();
		Channel c1 = new Channel();
		c1.setChannelName("BBC");
		c1.setDflag(false);
		Channel c2 = new Channel();
		c2.setChannelName("QTV");
		c2.setDflag(true);
		clist.add(c2);
		
		clist.add(c1);
		
		req.setReqChannels(clist);

		
		return new ResponseEntity<AccessRequest>(req,HttpStatus.OK);
		
	}
	
	private void testLog(){
		fileLogger.info("testLogMethod\n");
	}
}
