package com.duoc.consumers;


import org.springframework.stereotype.Service;

import com.duoc.models.Message;
import com.duoc.services.MessageService;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RabbitListener(queues = "cloud_native_queue")
public class CloudNativeConsumer {
    
    @Autowired
    private MessageService messageService;

    @RabbitHandler
    public void handleMessageRequest(String message) throws Exception {

        System.out.println(" Mensaje recibido '" + message + "'");

        Message messageModel = new Message();
        messageModel.setMessage(message);
        messageService.save(messageModel);
        System.out.println(" Mensaje guardado '" + messageModel.getMessage() + "'");
    }
}
