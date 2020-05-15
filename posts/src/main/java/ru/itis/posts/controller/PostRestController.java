package ru.itis.posts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.posts.model.Post;
import ru.itis.posts.service.PostService;

import java.util.List;

@RestController
public class PostRestController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postService.getAll();
    }

}


