package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{
}
