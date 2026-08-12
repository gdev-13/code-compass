package com.codecompass.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codecompass.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {
	Optional<User> findByEmail(String email);
}
