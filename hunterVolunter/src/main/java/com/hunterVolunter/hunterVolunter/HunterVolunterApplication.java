package com.hunterVolunter.hunterVolunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.hunterVolunter.hunterVolunter.models")
@SpringBootApplication
public class HunterVolunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(HunterVolunterApplication.class, args);
	}
	

}
