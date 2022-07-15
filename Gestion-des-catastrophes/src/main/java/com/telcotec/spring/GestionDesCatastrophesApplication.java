package com.telcotec.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.telcotec.spring.controlleur.WeatherService;
import com.telcotec.spring.view.MainView;

@SpringBootApplication
@ComponentScan(basePackageClasses=MainView.class)
public class GestionDesCatastrophesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesCatastrophesApplication.class, args);
	}

}
