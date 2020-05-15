package ru.itis.semestrovka.service;

import ru.itis.semestrovka.dto.CommentDto;

public interface CommentService {
    void makeComment(CommentDto form);
}
