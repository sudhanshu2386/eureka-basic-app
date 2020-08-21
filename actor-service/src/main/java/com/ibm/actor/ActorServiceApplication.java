package com.ibm.actor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ActorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActorServiceApplication.class, args);
	}
}
