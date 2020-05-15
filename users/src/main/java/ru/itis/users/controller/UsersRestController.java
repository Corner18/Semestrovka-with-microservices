package ru.itis.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.users.model.User;
import ru.itis.users.service.UsersService;

import java.util.List;

@RestController
public class UsersRestController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return usersService.getAllUsers();
    }
}