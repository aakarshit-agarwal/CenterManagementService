package com.fitness.CenterManagementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CenterManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CenterManagementServiceApplication.class, args);
	}

}
