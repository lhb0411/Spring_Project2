package com.hhblog.hanghae.controller;

import com.hhblog.hanghae.domain.Reply;
import com.hhblog.hanghae.repository.ReplyRepository;
import com.hhblog.hanghae.Dto.ReplyRequestDto;
import com.hhblog.hanghae.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final ReplyRepository replyRepository;
    private final ReplyService replyService;

    /* 댓글 조회 */
    @GetMapping("/api/reply")
    public List<Reply> getReply(@RequestParam(value = "article_id") Long article_id) {
        return null;
    }

    /* 댓글 입력 */
    /* 로그인하지 않은 사용자 확인 필요 security에서 principal에서 구분*/
    @PostMapping("/api/reply")
    public Reply createReply(@RequestBody ReplyRequestDto replyRequestDto) {
        Reply reply = new Reply(replyRequestDto);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return null;
    }

    /* 댓글 수정 */
    @PutMapping("/api/reply/{id}")
    public Long updateReply(@PathVariable Long id, @RequestBody ReplyRequestDto replyRequestDto) {
        return 0L;
    }

    /* 댓글 삭제 */
    @DeleteMapping("/api/reply/{id}")
    public Long deleteReply(@PathVariable Long id) {
        return 0L;
    }
}
