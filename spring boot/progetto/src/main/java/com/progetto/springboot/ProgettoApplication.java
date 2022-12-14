package com.progetto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.progetto.springboot.controller.UserController;

@SpringBootApplication
public class ProgettoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoApplication.class, args);
	}

}
