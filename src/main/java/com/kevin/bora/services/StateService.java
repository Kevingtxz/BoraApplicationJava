package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.State;
import com.kevin.bora.repositories.StateRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class StateService {

	@Autowired
	private StateRepository repo;
	
	public State find( Integer id ) {
		Optional<State> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + State.class.getName()));
	}
}
