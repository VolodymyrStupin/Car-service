package com.stupin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationWorkshopService {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationWorkshopService.class, args);
	}
}
