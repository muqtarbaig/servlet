package org.sample.service;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.apache.logging.log4j.core.appender.FileAppender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
//import org.apache.log4j.FileAppender;

//@Component
public class EventLogService {

	private static final Logger FILE_LOGGER = Logger.getLogger("EventLog");//LoggerFactory.getLogger("EventLogger");
	
	@Async
	public void logEvent(){
		try {
			FILE_LOGGER.addHandler(new FileHandler());
			//FILE_LOGGER.log(record);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void createAppender(){
		
	}
}
