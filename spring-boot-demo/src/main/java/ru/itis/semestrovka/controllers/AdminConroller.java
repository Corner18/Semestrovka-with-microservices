package ru.itis.semestrovka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.semestrovka.service.MessageService;
import ru.itis.semestrovka.security.details.UserDetailsImpl;


@Controller
public class AdminConroller {

    @Autowired
    private MessageService messageService;

    @GetMapping("/admin/{receiver}")
    public String getDialogues(Model model, Authentication authentication, @PathVariable("receiver") String receiver) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("admin", userDetails.getUsername());
        model.addAttribute("messages", messageService.getDialogue(userDetails.getUsername(), receiver));
        return "support";
    }

    @GetMapping("/admin")
    public String getDialoguesList(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("dialogues", messageService.getEmailsForAdminPage(userDetails.getUsername()));
        return "dialogues";
    }

}
