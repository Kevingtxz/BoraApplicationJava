package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.repositories.EventUsersRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class EventUsersService {

	@Autowired
	private EventUsersRepository repo;
	
	public EventUsers find( Integer id ) {
		Optional<EventUsers> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + EventUsers.class.getName()));
	}
}
