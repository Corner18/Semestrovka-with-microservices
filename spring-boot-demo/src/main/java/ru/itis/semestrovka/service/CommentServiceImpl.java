package ru.itis.semestrovka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.semestrovka.dto.CommentDto;
import ru.itis.semestrovka.models.Comment;
import ru.itis.semestrovka.repositories.CommentRepository;
import ru.itis.semestrovka.repositories.PostRepository;
import ru.itis.semestrovka.repositories.UsersRepository;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void makeComment(CommentDto form) {
        Comment comment = Comment.builder()
                .post(postRepository.getOne(form.getPost_id()))
                .user(usersRepository.getOne(form.getUser_id()))
                .text(form.getComment())
                .build();

        commentRepository.save(comment);
    }
}
