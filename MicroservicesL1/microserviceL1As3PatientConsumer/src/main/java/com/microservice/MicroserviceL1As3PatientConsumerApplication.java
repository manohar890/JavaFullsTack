package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviceL1As3PatientConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceL1As3PatientConsumerApplication.class, args);
	}

}
