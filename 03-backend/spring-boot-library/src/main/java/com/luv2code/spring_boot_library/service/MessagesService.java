package com.luv2code.spring_boot_library.service;

import com.luv2code.spring_boot_library.dao.MessageRepository;
import com.luv2code.spring_boot_library.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.transaction.Transactional;

@Service
@Transactional
public class MessagesService {
    private MessageRepository messageRepository;
    @Autowired
    public MessagesService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }
    public void postMessage(Message messageRequest, String userEmail){
        Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());
        message.setUserEmail(userEmail);
        messageRepository.save(message);
    }
}
