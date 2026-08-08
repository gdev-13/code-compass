package com.codecompass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codecompass.entity.KnowledgeProfile;

public interface KnowledgeProfileRepository extends JpaRepository<KnowledgeProfile, Long> {

}
