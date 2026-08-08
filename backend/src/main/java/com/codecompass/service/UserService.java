package com.codecompass.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codecompass.dto.user.CreateUserRequest;
import com.codecompass.dto.user.UserResponse;
import com.codecompass.entity.User;
import com.codecompass.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserResponse createUser (CreateUserRequest request) {
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		User savedUser = userRepository.save(user);
		
		UserResponse response = new UserResponse();
		response.setId(savedUser.getId());
		response.setName(savedUser.getName());
		response.setEmail(savedUser.getEmail());
		response.setCreatedAt(savedUser.getCreatedAt());
		
		return response;
	}
}
