package ru.itis.semestrovka.service;

public interface EmailService {
    void sendMail(String subject, String text, String email);
}
