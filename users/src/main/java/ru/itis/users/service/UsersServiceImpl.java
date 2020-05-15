package ru.itis.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.users.model.User;
import ru.itis.users.repository.UsersRepository;


import java.util.List;


@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<User> getAllUsers() {
        List<User> users = usersRepository.findAll();
        return users;
    }

}
