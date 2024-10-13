package com.backend.backend.repository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.backend.domain.Message;

@SpringBootTest
class MessageRepositoryTest {

    @Mock
    private MessageRepository repository;

    private Message messageObj;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        messageObj = new Message();
    }

    @Test
    void shootRegisterMessage() {

        messageObj.setId(UUID.randomUUID());
        messageObj.setUsername("jose");
        messageObj.setContent("Conteudo mensagem");

        when(repository.save(messageObj)).thenReturn(messageObj);

        Message messageSaved = repository.save(messageObj);

        assertNotNull(messageSaved.getId());
        verify(repository, times(1)).save(any(Message.class));

    }

    @Test
    void shootUpdateMessage() {
        fail("Test not Implemented");
    }

    @Test
    void shootDeleteMessage() {
        fail("Test not Implemented");
    }

    @Test
    void shootListMessage() {
        fail("Test not Implemented");
    }

}
