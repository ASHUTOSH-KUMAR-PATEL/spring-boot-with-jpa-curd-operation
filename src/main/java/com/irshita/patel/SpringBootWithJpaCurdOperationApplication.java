package com.irshita.patel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.irshita.patel")
public class SpringBootWithJpaCurdOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithJpaCurdOperationApplication.class, args);
	}

}
