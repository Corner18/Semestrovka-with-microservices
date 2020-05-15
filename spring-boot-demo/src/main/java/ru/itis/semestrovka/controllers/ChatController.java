package ru.itis.semestrovka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.semestrovka.service.MessageService;
import ru.itis.semestrovka.service.UsersService;
import ru.itis.semestrovka.security.details.UserDetailsImpl;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/support")
    public String getIndexPage(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("admin", usersService.getAdmin().getEmail());
        model.addAttribute("messages", messageService.getDialogue(userDetails.getUsername(), usersService.getAdmin().getEmail()));
        return "support";
    }
}
