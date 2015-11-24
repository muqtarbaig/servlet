package org.sample.util;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

public class EventLogger {
	
	private static final Logger FILE_LOGGER = Logger.getLogger("LoggerLog");//Logger.getLogger("EventLogger");
	private static final org.slf4j.Logger slogger = LoggerFactory.getLogger("EventLogger");
	
	public  static org.slf4j.Logger getLogger(){
		FILE_LOGGER.info("In EventLogger getLogger ******* ");
		if(slogger!= null)
			return slogger; //FILE_LOGGER;

		FILE_LOGGER.info("Returning from new factory ******* ");
		return  LoggerFactory.getLogger("EventLogger") ;//Logger.getLogger("EventLogger");
	}

}
