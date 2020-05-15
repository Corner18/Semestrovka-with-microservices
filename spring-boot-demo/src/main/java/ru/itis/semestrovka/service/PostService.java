package ru.itis.semestrovka.service;

import ru.itis.semestrovka.models.Comment;
import ru.itis.semestrovka.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Comment> userComment(Long post_id);

    Optional<Post> getOne(Long id);

}
