package ru.itis.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.users.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}


