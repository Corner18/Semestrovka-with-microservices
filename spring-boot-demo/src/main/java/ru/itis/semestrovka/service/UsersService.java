package ru.itis.semestrovka.service;


import ru.itis.semestrovka.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();

    User getUser(Long userId);

    User getAdmin();
}
