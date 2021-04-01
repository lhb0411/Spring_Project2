package com.hhblog.hanghae.controller;

import com.hhblog.hanghae.domain.Comment;
import com.hhblog.hanghae.domain.CommentSpecs;
import com.hhblog.hanghae.repository.ReplyRepository;
import com.hhblog.hanghae.Dto.ReplyRequestDto;
import com.hhblog.hanghae.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CommentController {

    private final ReplyRepository replyRepository;
    private final ReplyService replyService;

    @GetMapping("/api/comments")
    public List<Comment> getComment(@RequestParam(value = "notice_id") Long notice_id) {
        return null;
    }


    @GetMapping("/api/comments/{notice_id}")
    public List<Comment> getComment(@PathVariable Long notice_id) {
        return replyRepository.findAll(CommentSpecs.withArticle_id(notice_id));
    }


    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody ReplyRequestDto replyRequestDto) {
        Comment comment = new Comment(replyRequestDto);
        return replyRepository.save(comment);
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.update_comment(id, replyRequestDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        replyRepository.deleteById(id);
        return id;
    }
}

