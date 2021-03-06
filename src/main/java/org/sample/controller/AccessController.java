package org.sample.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sample.exception.MyException;
import org.sample.service.AccessValidator;
import org.sample.vo.AccessRequest;
import org.sample.vo.Channel;
import org.sample.vo.RandomQuote;
import org.sample.vo.ActionParam;
import org.sample.vo.SDEligibilityRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;


@RestController
public class AccessController {

	@Autowired
	private AccessValidator accessValidator;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	private static final Logger Logger = LoggerFactory.getLogger(AccessController.class);
	private static final Logger fileLogger = LoggerFactory.getLogger("EventLogger");// EventLogger.getLogger();
	
	@RequestMapping(value="/access",method = RequestMethod.POST)
	public String authorizeAccess(@RequestBody AccessRequest request){
	
		ServletRequestAttributes servletRequest = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		Logger.info("Session id "+servletRequest.getSessionId());
		
		Logger.info("Access Request :: "+request);
		fileLogger.info(request.toString()+"\n"); 
		
		if(request.getName().toLowerCase().contains("muqtar")){
			RestTemplate restTemplate = new RestTemplate();
			RandomQuote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", RandomQuote.class);
			Logger.info(quote.toString());
		}
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
	
	
	@RequestMapping(name = "/eligibility", method = RequestMethod.GET)
	public ResponseEntity<String> checkEligibilty(@ModelAttribute SDEligibilityRequest request){
		Logger.info("Eligibility request {}",request);
		return null;
	}
	
	private void testLog(){
		fileLogger.info("testLogMethod\n");
	}
	
	public static void main(String[] args) {
		ActionParam param = new ActionParam();
		param.setEt("eToken123");
		param.setSid("siteId123");
		param.setSig("signature123");
		
		Set<ActionParam> params = new HashSet<ActionParam>();
		params.add(param);
		
		Set<String> actions = new HashSet<String>();
		actions.add("vodads");
		actions.add("nonce");
		
		SDEligibilityRequest request = new SDEligibilityRequest();
		request.setParams(params);
		request.setActions(actions);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(request);
		System.out.println(json);
		
		
	}
}
