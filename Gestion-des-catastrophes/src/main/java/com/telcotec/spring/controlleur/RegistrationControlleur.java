package com.telcotec.spring.controlleur;
import com.telcotec.spring.service.RegistrationService;
import com.telcotec.spring.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.telcotec.spring.entities.user;
import com.telcotec.spring.repository.UserRepository;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationControlleur {
 @Autowired
 private UserRepository userRepository;
	
    private final RegistrationService registrationService;

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
	   System.out.println(userData);
	   user user= userRepository.findById(userData.getId());
	   if(user.getPassword().equals(userData.getPassword()))
		   return ResponseEntity.ok(user);
	   return  (ResponseEntity<?>) ResponseEntity.internalServerError();
	   
   }

}