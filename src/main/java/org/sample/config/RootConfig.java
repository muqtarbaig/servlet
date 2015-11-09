package org.sample.config;

import org.sample.service.AgeValidator;
import org.sample.service.AgeValidatorImpl;
import org.sample.service.EmailMessage;
import org.sample.service.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sample")
@EnableScheduling
public class RootConfig {

	 @Bean
	    public ViewResolver viewResolver() {
		 InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		 irvr.setPrefix("/WEB-INF/");
		 irvr.setSuffix(".jsp");
		 return irvr;
	    }
	 
	 @Bean
	 public Message message(){
		 return new EmailMessage();
	 }

	 @Bean
	 public AgeValidator validator(){
		 return new AgeValidatorImpl();
	 }
	 
	 @Bean
	 public TaskScheduler cts(){
		 return new ConcurrentTaskScheduler();
	 }
	
	 @Bean
	 public CommonsMultipartResolver multipartResolver(){
		 return new CommonsMultipartResolver();
	 }
	 
}
