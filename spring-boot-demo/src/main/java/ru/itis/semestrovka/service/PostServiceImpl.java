package ru.itis.semestrovka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.semestrovka.models.Comment;
import ru.itis.semestrovka.models.Post;
import ru.itis.semestrovka.repositories.CommentRepository;
import ru.itis.semestrovka.repositories.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> userComment(Long post_id) {
        List<Comment> commentList = commentRepository.getAllByPost_Id(post_id);
        return commentList;
    }

    @Override
    public Optional<Post> getOne(Long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            return Optional.of(post);
        } else {
            return Optional.empty();
        }
    }

}
