package com.kevin.bora.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.services.EventUsersService;

@RestController
@RequestMapping(value="/eventusers")
public class EventUsersResource {
	
	@Autowired
	private EventUsersService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<EventUsers> find(@PathVariable Integer id) {
		EventUsers obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}