package ru.itis.semestrovka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.semestrovka.models.Role;
import ru.itis.semestrovka.models.User;
import ru.itis.semestrovka.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<User> getAllUsers() {
        List<User> users = usersRepository.findAll();
        return users;
    }

    @Override
    public User getUser(Long userId) {
        return usersRepository.getOne(userId);
    }

    @Override
    public User getAdmin() {
        Optional<User> userOptional = usersRepository.findByRole(Role.ADMIN);
        return userOptional.orElse(null);
    }
}
