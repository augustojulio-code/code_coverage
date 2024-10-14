package com.backend.backend.repository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.h2.command.dml.MergeUsing.When;
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

        messageObj = genericMessage();

        when(repository.save(messageObj)).thenReturn(messageObj);

        Message messageSaved = repository.save(messageObj);

        assertNotNull(messageSaved.getId());
        verify(repository, times(1)).save(any(Message.class));

    }

    /*
     * @Test
     * void shootUpdateMessage() {
     * fail("Test not Implemented");
     * }
     */

    @Test
    void shootDeleteMessage() {
        UUID id = UUID.randomUUID();

        doNothing().when(repository).deleteById(any(UUID.class));

        repository.deleteById(id);

        verify(repository, times(1)).deleteById(any(UUID.class));
    }

    @Test
    void shootListMessage() {

        UUID id = UUID.randomUUID();
        Message message = genericMessage();
        message.setId(id);

        when(repository.findById(any(UUID.class)))
                .thenReturn(Optional.of(message));

        Optional<Message> messageFound = repository.findById(id);
        assertTrue(messageFound.isPresent());
        assertTrue(messageFound.get().getId().equals(id));
        assertTrue(messageFound.get().getContent().equals(message.getContent()));

        verify(repository, times(1)).findById(any(UUID.class));

    }

    @Test
    void shootListAllMessages() {

        List<Message> messageReceive = Arrays.asList();
        List messageList = Arrays.asList(
                genericMessage(),
                genericMessage());

        when(repository.findAll()).thenReturn(messageList);

        messageReceive = repository.findAll();

        assertNotNull(messageReceive);
        assertTrue(!messageReceive.isEmpty());
        assertEquals(2, messageReceive.size());

    }

    private Message genericMessage() {

        return Message.builder()
                .id(UUID.randomUUID())
                .username("Jose")
                .content("Conteudo")
                .build();
    }

}
