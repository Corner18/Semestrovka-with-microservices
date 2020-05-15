package ru.itis.semestrovka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.semestrovka.security.details.UserDetailsImpl;
import ru.itis.semestrovka.service.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{post_id}")
    public String getPostPage(Model model, Authentication authentication, @PathVariable("post_id") Long post_id) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("comments", postService.userComment(post_id));
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("post", postService.getOne(post_id).get());
        return "post";
    }

}
