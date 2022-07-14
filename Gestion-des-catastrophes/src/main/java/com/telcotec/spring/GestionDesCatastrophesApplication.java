package com.telcotec.spring;
import com.telcotec.spring.entities.user;
import com.telcotec.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import antlr.collections.List;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class GestionDesCatastrophesApplication {
	
	
	

	public static void main(String[] args) {
	
		SpringApplication.run(GestionDesCatastrophesApplication.class, args);
	}

}
