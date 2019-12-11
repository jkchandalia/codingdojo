package com.codingdojo.authentications.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.authentications.models.Message;
import com.codingdojo.authentications.repositories.MessageRepository;

@Service
public class MessageService {
	private MessageRepository messageRepository;
	
	public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
	// returns all the messages
    public List<Message> allMessages() {
        return messageRepository.findAll();
    }
    
    // creates a message
    public Message createMessage(Message b) {
        return messageRepository.save(b);
    }
    // retrieves a message
	    public Message findMessage(Long id) {
	        Optional<Message> optionalMessage = messageRepository.findById(id);
	        if(optionalMessage.isPresent()) {
	            return optionalMessage.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteMessage(Long id) {
			messageRepository.deleteById(id);
			
		}
		public Message updateMessage(Message message) {	
			messageRepository.save(message);
			return null;
		}
}
