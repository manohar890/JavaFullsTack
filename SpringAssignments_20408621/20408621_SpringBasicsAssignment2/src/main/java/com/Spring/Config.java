package com.Spring;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean(initMethod = "init",destroyMethod = "destroy")
	public Movie movie() {
		return new Movie();
	}
	
	
}
