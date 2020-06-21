package com.example.sweater.service;

import com.example.sweater.domain.User;
import com.example.sweater.domain.dto.MessageDto;
import com.example.sweater.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

@Service
public class MessageService {
    @Autowired
    private MessageRepository mesRep;

    @Autowired
    private EntityManager em;

    public List<MessageDto> messageList(String filter, User user) {
        if (filter != null && !filter.isEmpty()) {
            return mesRep.findByTag(filter, user);
        } else
            return mesRep.findAll(user);
    }

    public Set<MessageDto> messagesForUser(User currentUser, User author) {
        return mesRep.findByUser(currentUser, author);
    }
}
