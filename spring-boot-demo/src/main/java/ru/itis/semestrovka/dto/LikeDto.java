package ru.itis.semestrovka.dto;

import lombok.Data;

@Data
public class LikeDto {
    private Long user_id;
    private Long post_id;
}
