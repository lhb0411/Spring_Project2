package com.hhblog.hanghae.Dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ReplyRequestDto {
    private Long id;
    private Long article_id;
    private String username;
    private String contents;
}