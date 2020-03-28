package com.kevin.bora.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.bora.domain.Event;
import com.kevin.bora.services.EventService;

@RestController
@RequestMapping(value="/events")
public class EventResource {
	
	@Autowired
	private EventService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Event> find(@PathVariable Integer id) {
		Event obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/*
	 Solve this problem after
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EventDTO>> findPage(
			@RequestParam(value="name", defaultValue="") String name, 
			@RequestParam(value="category", defaultValue="") Category category, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="name") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Event> list = service.search(name,  (category==null) ? null : category.getId(), page, linesPerPage, orderBy, direction);
		Page<EventDTO> listDto = list.map(obj -> new EventDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	*/
}