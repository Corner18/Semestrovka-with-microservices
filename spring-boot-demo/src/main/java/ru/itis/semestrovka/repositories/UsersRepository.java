package ru.itis.semestrovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrovka.models.Role;
import ru.itis.semestrovka.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByConfirmCode(String token);

    Optional<User> findByRole(Role role);

}


