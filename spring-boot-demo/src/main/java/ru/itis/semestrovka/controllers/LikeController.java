package ru.itis.semestrovka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovka.service.LikeService;
import ru.itis.semestrovka.dto.LikeDto;
import ru.itis.semestrovka.security.details.UserDetailsImpl;

@Controller
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/like/{post_id}")
    public String makeLike(Authentication authentication, @PathVariable("post_id") Long post_id, LikeDto form) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        form.setPost_id(post_id);
        form.setUser_id(userDetails.getUser().getId());
        likeService.makeLike(form);
        return "redirect:/post/" + post_id;
    }

}
