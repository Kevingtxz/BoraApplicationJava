package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Address;
import com.kevin.bora.repositories.AddressRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;
	
	public Address find( Integer id ) {
		Optional<Address> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + Address.class.getName()));
	}
}