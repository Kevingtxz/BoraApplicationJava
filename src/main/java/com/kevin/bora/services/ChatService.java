package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.kevin.bora.domain.Chat;
import com.kevin.bora.dto.ChatDTO;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class ChatService {

		@Autowired
		private ChatRepository repo;
		
		public Chat find( Integer id ) {
			Optional<Chat> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Object not find! Id: " + id + ", Type: " + Chat.class.getName()));
		}
		
		public Chat insert(Chat obj) {
			obj.setId(null);
			return repo.save(obj);
		}

		public Chat update (Integer id, ChatDTO objDto) {
			Chat findObj = find(id);
			Chat obj = updateData(findObj, objDto.getReceptor(), objDto.getMessage());
			return repo.save(obj);
		}
		
		public void delete(Integer id) {
			find(id);
			try {
			repo.deleteById(id);
			}
			catch(DataIntegrityViolationException e) {
				throw new DataIntegrityException("It's impossible to delete a chat with users");
			}
		}
		
		public Chat updateData(Chat obj, Integer receptor, String msg) { 
				for(int a = 0 ; a < obj.getMessages().size() ; a++) {
					if(obj.getMessages().get(a).getReceiver() == receptor) {
						obj.getMessages().get(a).getMessages().add(msg);
						return repo.save(obj);
					}
				}
				throw new ObjectNotFoundException("Object not find! Id: " + receptor + ", Type: " + Chat.class.getName());
		}
		
		public Chat fromDTO(ChatDTO objDto) {
			return new Chat(objDto.getId());
		}
}