package com.hhblog.hanghae.service;

import com.hhblog.hanghae.domain.Comment;
import com.hhblog.hanghae.repository.CommentRepository;
import com.hhblog.hanghae.Dto.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update_comment(Long id, CommentRequestDto commentRequestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        comment.update_comment(commentRequestDto);
        return comment.getId();

    }

}