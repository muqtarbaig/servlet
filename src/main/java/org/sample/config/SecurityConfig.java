package org.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public void globalSecurityConfig(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication().withUser("admin").password("admin123").roles("USER");
	}
}
