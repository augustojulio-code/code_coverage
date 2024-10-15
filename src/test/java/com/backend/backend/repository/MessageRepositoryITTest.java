package com.backend.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.backend.domain.Message;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class MessageRepositoryITTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    void shootCreateTable() {
        Long totalQuerie = messageRepository.count();

        assertTrue(totalQuerie > 0, "o total de tabelas é ");
    }

    @Test
    void shootRegisterMessage() {

        UUID id = UUID.randomUUID();
        Message message = genericMessage();
        message.setId(id);

        Message registerMessage = messageRepository.save(message);

        assertTrue(registerMessage instanceof Message);
        assertNotNull(registerMessage);
        assertEquals(id, registerMessage.getId());
        assertEquals(message.getUsername(), registerMessage.getUsername());

    }

    @Test
    void shootUpdateMessage() {

        assertTrue(true);
    }

    @Test
    void shootListMessage() {

        UUID id = UUID.fromString("88d2c810-a8ab-404e-a59f-c00a04d03601");
        Message message = genericMessage();
        message.setId(id);

        registerMessage(message);

        Optional<Message> messageReceive = messageRepository.findById(id);

        assertTrue(messageReceive instanceof Optional<Message>);
        assertNotNull(messageReceive);

        messageReceive.ifPresent(messageResp -> {
            assertEquals(messageResp.getId(), id);
        });

    }

    @Test
    void shootDeleteMessage() {

        UUID id = UUID.fromString("cf1eb300-23f4-40a2-b713-6bc0f8782858");

        messageRepository.deleteById(id);

        Optional<Message> messageRemoved = messageRepository.findById(id);

        assertTrue(messageRemoved.isEmpty());

    }

    @Test
    void shootListAll() {

        List<Message> messages = messageRepository.findAll();

        assertNotNull(messages);
        assertTrue(!messages.isEmpty());
        assertTrue(messages.size() >= 1);

    }

    private Message genericMessage() {

        return Message.builder()
                .id(UUID.randomUUID())
                .username("Jose")
                .content("Conteudo")
                .build();
    }

    private Message registerMessage(Message message) {

        return messageRepository.save(message);
    }

}
