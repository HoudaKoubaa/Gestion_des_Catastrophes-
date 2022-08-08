package com.telcotec.spring.controlleur;
import com.telcotec.spring.service.IUserService;
import com.telcotec.spring.service.RegistrationService;
import com.telcotec.spring.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.telcotec.spring.entities.user;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationControlleur {

	@Autowired
	IUserService userService;
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
    
    @GetMapping("/list-user")
	List<user> retrieveAllUsers(){
		
		return userService.retrieveAllUsers();
	}
	
	
		

	}


