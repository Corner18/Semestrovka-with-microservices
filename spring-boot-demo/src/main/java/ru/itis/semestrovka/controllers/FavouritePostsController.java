package ru.itis.semestrovka.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.semestrovka.models.Post;
import ru.itis.semestrovka.security.details.UserDetailsImpl;
import ru.itis.semestrovka.service.FavouritesService;

import java.util.List;

@Controller
public class FavouritePostsController {

    @Autowired
    private FavouritesService favouritesService;

    @GetMapping("/favourites")
    public String getFavourites(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<Post> postList = favouritesService.favs(userDetails.getUser().getId());
        model.addAttribute("posts", postList);
        model.addAttribute("user", userDetails.getUser());
        return "posts";

    }
}
