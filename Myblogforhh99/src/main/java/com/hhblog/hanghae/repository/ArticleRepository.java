package com.hhblog.hanghae.repository;

import com.hhblog.hanghae.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByOrderByModifiedAtDesc();
}