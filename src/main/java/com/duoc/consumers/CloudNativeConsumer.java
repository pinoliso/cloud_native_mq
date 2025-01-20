package com.duoc.consumers;


import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
@RabbitListener(queues = "cloud_native_queue")
public class CloudNativeConsumer {
    @RabbitHandler
    public void handleMessageRequest(byte[] message) throws Exception {
        System.out.println(new String(message));
    }
}
