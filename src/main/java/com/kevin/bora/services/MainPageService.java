package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.MainPage;
import com.kevin.bora.repositories.MainPageRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class MainPageService {

	@Autowired
	private MainPageRepository repo;
	
	public MainPage find( Integer id ) {
		Optional<MainPage> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + MainPage.class.getName()));
	}
}