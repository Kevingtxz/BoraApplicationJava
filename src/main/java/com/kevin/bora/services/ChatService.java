package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Chat;
import com.kevin.bora.domain.MainPage;
import com.kevin.bora.domain.Message;
import com.kevin.bora.dto.ChatDTO;
import com.kevin.bora.dto.ChatNewDTO;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class ChatService {

		@Autowired
		private ChatRepository repo;
		@Autowired
		private MainPageService mainPageService;
		
		public Chat find( Integer id ) {
			Optional<Chat> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Object not find! Id: " + id + ", Type: " + Chat.class.getName()));
		}

	
	public Chat insert(ChatNewDTO objNewDto) {
		Chat newObj = new Chat(null);
		for(int a = 0; a < objNewDto.getMainPages_ids().size(); a++) {
			newObj.getMainPages().add(mainPageService.find(objNewDto.getMainPages_ids().get(a)));
		}
		return repo.save(newObj);
	}
	
	public Chat update (Integer id, ChatDTO objDto) {
		Chat findObj = find(id);
		Chat obj = updateData(findObj, objDto.getSender(), objDto.getMessage());
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
	
	public Chat updateData(Chat obj, Integer sender_id, String msg) { 
			Message newMsg = new Message(null, sender_id, msg);
			obj.getMessages().add(newMsg);
			return obj;
		}
	
	public Chat findByMainPages(List<MainPage> mainPages) {
		List<Chat> chats = repo.findAll();
		for(int a = 0; a < chats.size(); a++) {
			if(chats.get(a).getMainPages() == mainPages) {
				return chats.get(a);
			}
		}
		throw new ObjectNotFoundException("Não existe chat com esses membros");
	}	
	public boolean checkMainPagesInChat(List<MainPage> mainPages) {
		List<Chat> chats = repo.findAll();
		for(int a = 0; a < chats.size(); a++) {
			if(chats.get(a).getMainPages() == mainPages) {
				return true;
			}
		}
		return false;
	}
}














