package ru.itis.semestrovka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.semestrovka.models.User;
import ru.itis.semestrovka.security.details.UserDetailsImpl;
import ru.itis.semestrovka.service.UsersService;

@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/profile")
    public String getUsersPage(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = usersService.getUser(userDetails.getUser().getId());
        model.addAttribute("user", user);
        return "profile";
    }
}
