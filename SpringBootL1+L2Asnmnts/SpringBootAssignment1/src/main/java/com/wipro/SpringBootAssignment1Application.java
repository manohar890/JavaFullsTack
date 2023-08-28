package com.wipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootAssignment1Application implements CommandLineRunner {
	@Autowired
	private ApplicationContext applicationContext;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignment1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String []beans=applicationContext.getBeanDefinitionNames();
		for(String b:beans) {
			System.out.println(b);
		}
	}

}
