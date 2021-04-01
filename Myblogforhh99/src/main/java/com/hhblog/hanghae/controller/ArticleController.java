package com.hhblog.hanghae.controller;

import com.hhblog.hanghae.domain.Article;
import com.hhblog.hanghae.repository.ArticleRepository;
import com.hhblog.hanghae.Dto.ArticleRequestDto;
import com.hhblog.hanghae.security.UserDetailsImpl;
import com.hhblog.hanghae.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @PostMapping("/api/notices")
    // requestDto 는, 생성 요청을 의미
    // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 함.
    public Article createNotice(@RequestBody ArticleRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Article article = new Article(requestDto, userDetails);
        articleRepository.save(article);
        return article;
    }

    @GetMapping("/api/notices")
    public List<Article> getNotice() {
        return articleRepository.findAllByOrderByModifiedAtDesc();
    }


    @PutMapping("/api/notices/{id}")
    public Long updateNotice(@PathVariable Long id, @RequestBody ArticleRequestDto requestDto) {
        articleService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/notices/{id}")
    public Long deleteNotice(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return id;
    }
}