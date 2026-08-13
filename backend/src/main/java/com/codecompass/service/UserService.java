package com.codecompass.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codecompass.dto.user.CreateUserRequest;
import com.codecompass.dto.user.LoginRequest;
import com.codecompass.dto.user.LoginResponse;
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
		Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
		if(existingUser.isPresent()) {
			throw new RuntimeException("E-mail já cadastrado");
		}
	
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
	
	public LoginResponse login (LoginRequest request) {
		Optional<User> user = userRepository.findByEmail(request.getEmail());
		User userEntity = user
				.orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos"));
		
		boolean passwordMatches = passwordEncoder.matches(
			    request.getPassword(),
			    userEntity.getPassword()
		);
		
		if (!passwordMatches) {
			throw new RuntimeException("E-mail ou senha inválidos");
		};
		
		LoginResponse response = new LoginResponse();
		response.setId(userEntity.getId());
		response.setName(userEntity.getName());
		response.setEmail(userEntity.getEmail());
		
		return response;
	}
}
