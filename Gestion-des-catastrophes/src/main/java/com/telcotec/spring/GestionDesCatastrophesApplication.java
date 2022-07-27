package com.telcotec.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.telcotec.spring")
public class GestionDesCatastrophesApplication{

	  
	public static void main(String[] args) {
		SpringApplication.run(GestionDesCatastrophesApplication.class, args);
		System.out.println("User Applications Started Running ");

	}

	
}
