package com.Application.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = { "com.Application.Application.entity" })
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		System.out.println("Application Started");
	}

}
