package ru.itis.semestrovka.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.itis.semestrovka.models.User;
import ru.itis.semestrovka.service.EmailService;
import ru.itis.semestrovka.service.UsersService;

import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
public class MaillingUtil {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UsersService usersService;

    @Scheduled(cron = "0 0 12 1 * ?")
    public void sayHello(){
        List<User> users = usersService.getAllUsers();
        users.forEach(user -> {
            emailService.sendMail("Просто здравствуй, просто как дела",
                    "Чмоки всем в этом чатике:* Спасибо что остаетесь с нами!",
                    user.getEmail());
        });
    }
}
