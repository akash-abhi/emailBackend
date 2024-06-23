package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class RtoEmail1Application {

	public static void main(String[] args) {
		SpringApplication.run(RtoEmail1Application.class, args);
	}

}
