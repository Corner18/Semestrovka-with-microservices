package ru.itis.semestrovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrovka.models.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getAllByPost_Id(Long post_id);
}
