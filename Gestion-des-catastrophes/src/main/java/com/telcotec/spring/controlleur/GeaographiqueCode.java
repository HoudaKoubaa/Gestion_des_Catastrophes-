package com.telcotec.spring.controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeaographiqueCode {

	@GetMapping("/test")
	public String affiche() {
		return "hello";
	}
}
