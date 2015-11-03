package org.sample.config;

import org.sample.service.EmailMessage;
import org.sample.service.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sample")
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

}
