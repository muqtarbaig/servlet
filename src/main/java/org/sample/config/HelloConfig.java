package org.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sample.controller")
public class HelloConfig {

	 @Bean
	    public ViewResolver viewResolver() {
		 InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		 irvr.setPrefix("/WEB-INF/");
		 irvr.setSuffix(".jsp");
		 return irvr;
	    }
	 
}
