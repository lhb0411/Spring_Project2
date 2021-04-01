package com.hhblog.hanghae.Dto;

import lombok.Getter;

//DTO Class : DB를 안건드리고 내용을 주고받기 위한 완충재.
@Getter
public class ArticleRequestDto {
    private String title;
    private String username;
    private String contents;
}
