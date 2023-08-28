package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MicroserviceL1As4EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceL1As4EurekaServerApplication.class, args);
	}

}
