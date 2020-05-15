package ru.itis.semestrovka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovka.dto.RegistrationDto;
import ru.itis.semestrovka.service.RegistrationService;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String getRegistrationPage(Authentication authentication, Model model) {
        if (authentication != null) {
            return "redirect:/profile";
        } else {
            model.addAttribute("profileForm", new RegistrationDto());
            return "registration";
        }
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("profileForm")RegistrationDto form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            System.out.println(form);
            model.addAttribute("profileForm", form);
            return "registration";
        } else {
            registrationService.registration(form);
            return "redirect:/login";
        }

    }
}
