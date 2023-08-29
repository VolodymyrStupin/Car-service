package com.stupin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ApplicationConfigService {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfigService.class, args);
	}
}
