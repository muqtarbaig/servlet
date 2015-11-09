package org.sample.service.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
//@Component
public class DateScheduler implements SchedulingConfigurer{

	private static final Logger LOGGER = LoggerFactory.getLogger(DateScheduler.class); 
	@Autowired
	private TaskScheduler cts ;
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
	
		//ThreadPoolTaskScheduler tpts;
		
		taskRegistrar.setTaskScheduler(cts);
		taskRegistrar.addFixedRateTask(new Runnable() {
			
			@Override
			public void run() {
				LOGGER.info("Date is "+new Date());
			}
		}, 10000);
		
	}

}
