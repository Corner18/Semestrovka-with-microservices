package ru.itis.semestrovka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.semestrovka.service.SearchService;
import ru.itis.semestrovka.dto.PostsSearchDto;
import ru.itis.semestrovka.security.details.UserDetailsImpl;

@Controller
@RequestMapping("/search")
public class SearchConroller {

    @Autowired
    private SearchService searchService;

    @PostMapping("/posts")
    public String searchProducts(Model model, Authentication authentication, @RequestParam("q") String query,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "size", required = false) Integer size) {

        PostsSearchDto postsSearchDto = searchService.searchPost(query, size, page);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("posts", postsSearchDto.getPosts());
        return "posts";
    }

}
