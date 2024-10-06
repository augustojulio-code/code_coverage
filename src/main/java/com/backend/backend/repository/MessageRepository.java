package com.backend.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.domain.Message;

public interface MessageRepository extends JpaRepository<Message, UUID> {

}
