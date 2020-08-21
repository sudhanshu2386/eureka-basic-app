package com.ibm.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ibm.ribbon.configuration.RibbonConfiguration;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = { "com.netflix.client.config.IClientConfig"})
@RibbonClient(name = "ribbon-service", configuration = RibbonConfiguration.class)
public class RibbonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonServiceApplication.class, args);
	}
}
