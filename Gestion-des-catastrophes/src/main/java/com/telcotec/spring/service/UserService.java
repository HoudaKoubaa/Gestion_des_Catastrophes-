package com.telcotec.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.telcotec.spring.service.ConfirmationTokenService;
import com.telcotec.spring.entities.ConfirmationToken;
import com.telcotec.spring.entities.user;
import com.telcotec.spring.repository.UserRepository;

import lombok.AllArgsConstructor;

@SuppressWarnings("unused")
@Service
@AllArgsConstructor
public class UserService implements  UserDetailsService,IUserService {

	@Autowired
	UserRepository appUserRepository1;
	private final static String USER_NOT_FOUND_MSG =
			"user with email %s not found";

	private final UserRepository appUserRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		return (appUserRepository1.findByEmail(email));
	}

	  public String signUpUser(user appUser) {
	        boolean userExists = appUserRepository
	                .findByEmail2(appUser.getEmail())
	                .isPresent();

	        if (userExists) {
	            // TODO check of attributes are the same and
	            // TODO if email not confirmed send confirmation email.

	            throw new IllegalStateException("email already taken");
	        }

	        String encodedPassword = bCryptPasswordEncoder
	                .encode(appUser.getPassword());

	        appUser.setMdp(encodedPassword);

	        appUserRepository.save(appUser);

	        String token = UUID.randomUUID().toString();

	        ConfirmationToken confirmationToken = new ConfirmationToken(
	                token,
	                LocalDateTime.now(),
	                LocalDateTime.now().plusMinutes(15),
	                appUser
	        );

	        confirmationTokenService.saveConfirmationToken(
	                confirmationToken);

//	        TODO: SEND EMAIL

	        return token;
	    }

	public int enableAppUser(String email) {
		return appUserRepository1.enableAppUser(email);
	}

	@Override
	public List<user> retrieveAllUsers() {
		List<user> userList = appUserRepository1.findAll();
		for (user user : userList){
			System.out.println(" User: " +user);
		}
		return userList;
}

	@Override
	public user addUser(user u) {
		appUserRepository1.save(u);
		return u;
	}

	@Override
	public user updateUser(user u) {
		appUserRepository1.save(u);
		return u;
	}



	@Override
	public void deleteUser(int id) {
		appUserRepository1.deleteById(id);		
	}
	
	
}