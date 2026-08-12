package com.codecompass.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codecompass.dto.user.CreateUserRequest;
import com.codecompass.dto.user.LoginRequest;
import com.codecompass.dto.user.LoginResponse;
import com.codecompass.dto.user.UserResponse;
import com.codecompass.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;
	
	@PostMapping("/register")
	public UserResponse register(@RequestBody CreateUserRequest request)  {
		return userService.createUser(request);
	}
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return userService.login(request);
	}
}