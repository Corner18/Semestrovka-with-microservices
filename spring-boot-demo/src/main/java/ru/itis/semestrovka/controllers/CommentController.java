package ru.itis.semestrovka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovka.service.CommentService;
import ru.itis.semestrovka.dto.CommentDto;
import ru.itis.semestrovka.security.details.UserDetailsImpl;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/{post_id}")
    public String makeComment(Authentication authentication, CommentDto form, @PathVariable("post_id") Long post_id) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        form.setUser_id(userDetails.getUser().getId());
        form.setPost_id(post_id);
        commentService.makeComment(form);
        return "redirect:/post/" + post_id;
    }
}
