package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
}
