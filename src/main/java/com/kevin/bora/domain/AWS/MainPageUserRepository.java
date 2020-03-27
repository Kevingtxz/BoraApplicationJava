package com.kevin.bora.domain.AWS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.MainPageUser;

@Repository
public interface MainPageUserRepository extends JpaRepository<MainPageUser, Integer>{
}
