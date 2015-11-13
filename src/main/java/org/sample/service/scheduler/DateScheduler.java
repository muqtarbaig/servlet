package org.sample.service.scheduler;

import java.util.Date;

import org.sample.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
@Component
public class DateScheduler implements SchedulingConfigurer{

	private static final Logger LOGGER = LoggerFactory.getLogger(DateScheduler.class); 
	@Autowired
	private ThreadPoolTaskScheduler cts ;
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
	
		//ThreadPoolTaskScheduler tpts;
		
		taskRegistrar.setTaskScheduler(cts);
		taskRegistrar.addFixedRateTask(new Runnable() {
			
			@Override
			public void run() {
				
				String date = new Date().toString();
				LOGGER.info("Date is "+date);
				if(date.contains(":01")){
					throw new MyException("Date invalid error", "This is not the right time ??");
				}
			}
		}, 10000);
		
	}

}
