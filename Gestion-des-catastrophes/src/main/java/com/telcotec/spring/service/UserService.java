package com.telcotec.spring.service;

import java.time.LocalDateTime;
import java.util.UUID;

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
public class UserService implements  UserDetailsService {

	private final static String USER_NOT_FOUND_MSG =
			"user with email %s not found";

	private final UserRepository appUserRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		return appUserRepository.findByEmail(email)
				.orElseThrow(() ->
				new UsernameNotFoundException(
						String.format(USER_NOT_FOUND_MSG, email)));
	}

	public String signUpUser(user appUser) {
		boolean userExists = appUserRepository.findByEmail(appUser.getUsername()).isPresent();

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

		//        TODO: SEND EMAIL

		return token;
	}

	public int enableAppUser(String email) {
		return appUserRepository.enableAppUser(email);
	}
}