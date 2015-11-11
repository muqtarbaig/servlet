package org.sample.service.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class TimeScheduler {

	private static final Logger _LOGGER = LoggerFactory.getLogger(TimeScheduler.class);
	private SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000 )
	public void getTime(){
		
		_LOGGER.info("Time is " +date.format(new Date()));
	}
}
