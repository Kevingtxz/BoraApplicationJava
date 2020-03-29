package com.kevin.bora.resources;

public class ChatResource {
	/*
	@Autowired
	private ChatService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Chat> find(@PathVariable Integer id) {
		Chat obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ChatNewDTO objNewDto){
		Chat obj = service.fromDTO(objNewDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(obj.getChatPk()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ChatDTO objDto, @PathVariable Integer id){
		Chat obj = service.update(id, objDto);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
*/
}
