package com.codecompass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codecompass.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
