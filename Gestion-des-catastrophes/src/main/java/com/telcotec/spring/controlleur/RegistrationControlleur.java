package com.telcotec.spring.controlleur;
import com.telcotec.spring.service.RegistrationService;

import com.telcotec.spring.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.telcotec.spring.entities.user;
import com.telcotec.spring.repository.UserRepository;
@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/registration" )
@AllArgsConstructor
public class RegistrationControlleur {
 @Autowired
 private UserRepository userRepository;
	
    private final RegistrationService registrationService;
    private PasswordEncoder paswword;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
    

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody user userData)
    {  
 	 user  users= userRepository.findByEmail(userData.getEmail());
 	 System.out.println(users.getEmail());

 	 System.out.println(users.getPassword());
    if(paswword.matches(userData.getPassword(),users.getPassword()))
    	
    	new ResponseEntity<user>(HttpStatus.OK);      
    
    else      
    	return new ResponseEntity< user>(HttpStatus.CONFLICT);
	return null;
 	   
    }

}