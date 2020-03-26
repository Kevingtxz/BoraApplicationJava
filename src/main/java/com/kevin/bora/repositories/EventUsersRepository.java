package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.EventUsers;

@Repository
public interface EventUsersRepository extends JpaRepository<EventUsers, Integer>{
}
