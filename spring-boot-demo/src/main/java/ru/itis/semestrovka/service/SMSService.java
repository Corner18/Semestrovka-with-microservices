package ru.itis.semestrovka.service;

import ru.itis.semestrovka.models.User;

public interface SMSService {
    void sendSms(User user, String text);
}
