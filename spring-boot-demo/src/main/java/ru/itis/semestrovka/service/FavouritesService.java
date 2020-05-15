package ru.itis.semestrovka.service;

import ru.itis.semestrovka.models.Post;

import java.util.List;

public interface FavouritesService {
    List<Post> favs(Long user_id);
}
