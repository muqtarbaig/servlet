package org.sample.service.scheduler;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
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
	private static final Logger FILE_LG = LoggerFactory.getLogger("EventLogger");
	private File logPath = new File(""); 
	private final int thresholdDuration = 14;
	private String fileNamePattern = "eula";

	@Autowired
	private ThreadPoolTaskScheduler taskScheduler ;

	private int duration = 60; 

	private void archive(){
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
			FILE_LG.info("LogField");

			//jarchive();

		}, "0 0/1 * 1/1 * ? ");

		taskRegistrar.setTaskScheduler(taskScheduler);

	}

	private void jarchive(){
		DateTimeZone timezone = DateTimeZone.forID("America/Los_Angeles");

		if(logPath.isDirectory()){
			List<File> files = Arrays.asList(logPath.listFiles());
			for(File eachFile : files){
				String eachFileName = eachFile.getName();
				boolean delteStatus = false;
				if(eachFileName.contains(fileNamePattern)){
					LOGGER.debug("File name : "+eachFileName);
					LOGGER.debug("Last modified date "+ new Date(eachFile.lastModified()).toString());

					DateTime fileTime = new DateTime(eachFile.lastModified(), timezone);
					DateTime now = DateTime.now(timezone);
					int fileAge = Days.daysBetween(fileTime.toLocalDate(), now.toLocalDate()).getDays();
					LOGGER.debug("File age: "+fileAge);
					if(fileAge>thresholdDuration){
						LOGGER.debug("Deleting file "+eachFileName);
						delteStatus = eachFile.delete();
						if(delteStatus)
							LOGGER.info(" File "+eachFileName+" deleted successfully ");
					}
				}else{LOGGER.debug("File pattern not matched for :: "+eachFileName);}
			}
		}
		else{LOGGER.info("Not valid file/Directory"+ logPath); }
	}
}
