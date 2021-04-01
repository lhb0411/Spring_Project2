package com.hhblog.hanghae.service;

import com.hhblog.hanghae.domain.Article;
import com.hhblog.hanghae.repository.ArticleRepository;
import com.hhblog.hanghae.Dto.ArticleRequestDto;
import com.hhblog.hanghae.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final 쓸때 생성자 자동 생성
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class ArticleService {
    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    private final ArticleRepository articleRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public Long update(Long id, AritcleRequestDto aritcleRequestDto){
        Article article = articleRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        article.update(aritcleRequestDto);
        return article.getId();
    }
}