package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.MainPage;

@Repository
public interface MainPageRepository extends JpaRepository<MainPage, Integer>{
}
