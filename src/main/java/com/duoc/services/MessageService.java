package com.duoc.services;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.duoc.repositories.MessageRepository;
import com.duoc.models.Message;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
