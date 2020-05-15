package ru.itis.semestrovka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.semestrovka.models.Likes;
import ru.itis.semestrovka.models.Post;
import ru.itis.semestrovka.repositories.LikeRepository;
import ru.itis.semestrovka.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouritesServiceImpl implements FavouritesService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> favs(Long user_id) {
        List<Likes> likes = likeRepository.getAllByUser_Id(user_id);
        List<Post> posts = new ArrayList<>();
        for (Likes like : likes) {
            posts.add(like.getPost());
        }
        return posts;
    }
}
