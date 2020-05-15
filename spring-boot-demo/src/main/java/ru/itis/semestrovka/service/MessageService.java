package ru.itis.semestrovka.service;

import ru.itis.semestrovka.dto.MessageDto;

import java.util.List;
import java.util.Set;

public interface MessageService {
    void save(MessageDto messageDto);

    List<MessageDto> getDialogue(String email1, String email2);

    Set<String> getEmailsForAdminPage(String adminEmail);
}
