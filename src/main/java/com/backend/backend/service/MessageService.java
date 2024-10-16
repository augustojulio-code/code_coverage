package com.backend.backend.service;

import java.util.List;
import java.util.UUID;

import com.backend.backend.domain.Message;

public interface MessageService {

    Message registerMessage(Message message);

    Message getMessage(UUID id);

    Message updateMessage(Message newMessage, Message oldMessaged);

    boolean deleteMessage(UUID id);

    List<Message> listMessage();

}
