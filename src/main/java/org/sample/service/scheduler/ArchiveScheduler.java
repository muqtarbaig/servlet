package org.sample.service.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

@Component
public class ArchiveScheduler implements SchedulingConfigurer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("");
	
	@Autowired
	private ThreadPoolTaskScheduler taskScheduler ;
	
	public void archive(){
		LOGGER.info("Deleting files ");
		
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		taskRegistrar.addCronTask(()->{
			LOGGER.info("Archiving every minute " + new Date().toString());
			
			archive();
			
		}, "0 0/1 * 1/1 * ? ");
		
		taskRegistrar.setTaskScheduler(taskScheduler);
		
	}

}
