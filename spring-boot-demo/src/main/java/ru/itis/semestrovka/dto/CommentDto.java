package ru.itis.semestrovka.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long user_id;
    private Long post_id;
    private String comment;
}
