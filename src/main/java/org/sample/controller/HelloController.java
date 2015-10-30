package org.sample.controller;

import org.sample.servlet.FirstServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController  {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FirstServlet.class);

	@RequestMapping(value = "/hello.htm")
	public String hello(){
		LOGGER.info("In Hello Controller handle Request");
		LOGGER.info("Returing hello jsp");
		return "hello";
	}

}
