package com.pythe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.pythe.*")
@ImportResource(locations = { "*/*.xml" })
@EnableScheduling
@EnableAsync
public class PytheTimerTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(PytheTimerTaskApplication.class, args);
	}
}
