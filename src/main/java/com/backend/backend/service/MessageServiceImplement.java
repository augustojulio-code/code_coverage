package com.backend.backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.backend.backend.domain.Message;
import com.backend.backend.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageServiceImplement implements MessageService {

    private final MessageRepository repository;

    @Override
    public Message registerMessage(Message message) {
        message.setId(UUID.randomUUID());
        return repository.save(message);
    }

    @Override
    public Message getMessage(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }

    @Override
    public Message updateMessage(Message newMessage, Message oldMessaged) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateMessage'");
    }

    @Override
    public boolean deleteMessage(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMessage'");
    }

    @Override
    public List<Message> listMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listMessage'");
    }

}
