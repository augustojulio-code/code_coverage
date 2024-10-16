package com.backend.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.backend.domain.Message;
import com.backend.backend.repository.MessageRepository;

@SpringBootTest
public class MessageServiceTest {

    private MessageService service;

    @Mock
    private MessageRepository repository;

    AutoCloseable mock;

    @BeforeEach
    void setup() {

        mock = MockitoAnnotations.openMocks(this);
        service = new MessageServiceImplement(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void shootMessageRegister() {

        Message message = genericMessage();

        when(repository.save(any(Message.class)))
                .thenAnswer(i -> i.getArgument(0));

        Message registerMessage = service.registerMessage(message);

        assertNotNull(registerMessage instanceof MessageService);

        assertEquals(message.getContent(), registerMessage.getContent());
        assertEquals(message.getUsername(), registerMessage.getUsername());
        assertNotNull(message.getId());

    }

    void shootGetMessage() {
        fail("Teste não implementado");
    }

    void shootUpdateMessage() {
        fail("Teste não implementado");
    }

    void shootDeleteMessage() {
        fail("Teste não implementado");
    }

    void shootListMessages() {
        fail("Teste não implementado");
    }

    private Message genericMessage() {

        return Message.builder()
                .id(UUID.randomUUID())
                .username("Jose")
                .content("Conteudo")
                .build();
    }

}
