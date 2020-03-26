package com.kevin.bora.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.bora.domain.Address;
import com.kevin.bora.services.AddressService;

@RestController
@RequestMapping(value="/address")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Address> find(@PathVariable Integer id) {
		Address obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}