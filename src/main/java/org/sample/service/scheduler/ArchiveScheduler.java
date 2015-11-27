package org.sample.service.scheduler;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	
	private int duration = 60; 
	
	public void archive(){
		LOGGER.info("Start archive ");
		//PropertiesUtil util = new PropertiesUtil("D:\\project\\servlet\\src\\main\\webapp\\WEB-INF\\log4j2.xml");
		//LOGGER.info(util.getStringProperty("archive-path"));
		
		File file = new File("O:\\logs\\muqtar");
		if(file.isDirectory()){
			List<File> files = Arrays.asList(file.listFiles());
			for(File eachFile : files){
				LOGGER.info("File name : "+eachFile.getName());
				LOGGER.info("Modified date "+eachFile.lastModified());
				LOGGER.info("Readable date "+ new Date(eachFile.lastModified()).toString());
				
				if((System.currentTimeMillis() - eachFile.lastModified()) > duration*1000){
					LOGGER.info("Deleting file");
					LOGGER.info("Status "+eachFile.delete());
				}
			}
		}
		
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
