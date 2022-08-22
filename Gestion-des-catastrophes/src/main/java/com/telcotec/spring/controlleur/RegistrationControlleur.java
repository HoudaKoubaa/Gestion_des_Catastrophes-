package com.telcotec.spring.controlleur;
import com.telcotec.spring.service.RegistrationService;

import com.telcotec.spring.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String loginUser(@RequestBody user userData)
    {  	   System.out.println(userData.getEmail());

 	   System.out.println(userData.getPassword());
 	 user  users= userRepository.findByEmail(userData.getEmail());
 	 System.out.println(users.getPassword());
    if(paswword.matches(userData.getPassword(),users.getPassword()))
 		   return "valide";
 	   return  "invalide";
 	   
    }

}