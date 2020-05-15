package ru.itis.semestrovka.service;

import ru.itis.semestrovka.dto.PostsSearchDto;

public interface SearchService {
    PostsSearchDto searchPost(String query, Integer size, Integer page);
}
