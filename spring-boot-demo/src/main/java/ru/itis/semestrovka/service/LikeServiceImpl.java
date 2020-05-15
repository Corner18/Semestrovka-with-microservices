package ru.itis.semestrovka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.semestrovka.dto.LikeDto;
import ru.itis.semestrovka.models.Likes;
import ru.itis.semestrovka.repositories.LikeRepository;
import ru.itis.semestrovka.repositories.PostRepository;
import ru.itis.semestrovka.repositories.UsersRepository;

@Component
public class LikeServiceImpl implements LikeService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private LikeRepository likeRepository;


    @Override
    public void makeLike(LikeDto form) {
        Likes like = Likes.builder()
                .post(postRepository.getOne(form.getPost_id()))
                .user(usersRepository.getOne(form.getUser_id()))
                .build();

        likeRepository.save(like);
    }
}
