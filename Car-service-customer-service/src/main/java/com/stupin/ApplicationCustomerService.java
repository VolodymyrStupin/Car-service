package com.stupin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationCustomerService {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationCustomerService.class, args);
	}
}
