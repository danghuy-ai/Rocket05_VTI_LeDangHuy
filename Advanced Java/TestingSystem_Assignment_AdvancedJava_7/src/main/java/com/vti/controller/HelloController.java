package com.vti.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@GetMapping(value = "/rocket05")
	public void hello() {
		System.out.println("Hello world rocket05_1");
	}
	
	@GetMapping
	public String hello2() {
		return "Hello world rocket05_2";
	}
	
	@PostMapping
	private ResponseEntity<?> postman() {
		return new ResponseEntity<>("Hello postman", HttpStatus.BAD_REQUEST);
		
	}
}
