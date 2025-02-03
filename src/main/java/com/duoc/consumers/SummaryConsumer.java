package com.duoc.consumers;


import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
@RabbitListener(queues = "summary")
public class SummaryConsumer {

    private static final String FILE_PATH = "mensajes.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitHandler
    public void handleMessageRequest(String message) throws Exception {

        System.out.println(" Mensaje recibido '" + message + "'");
        guardarEnJson(message);
        System.out.println(" Mensaje guardado en JSON '" + message + "'");
    }

    private void guardarEnJson(String nuevoMensaje) {
        List<String> mensajes = leerMensajesExistentes();

        mensajes.add(nuevoMensaje);

        try {
            objectMapper.writeValue(new File(FILE_PATH), mensajes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> leerMensajesExistentes() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            return objectMapper.readValue(content, List.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
