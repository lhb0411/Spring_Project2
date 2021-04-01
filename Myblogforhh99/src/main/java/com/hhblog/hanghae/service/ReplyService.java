package com.hhblog.hanghae.service;

import com.hhblog.hanghae.domain.Comment;
import com.hhblog.hanghae.domain.Reply;
import com.hhblog.hanghae.repository.ReplyRepository;
import com.hhblog.hanghae.Dto.ReplyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional
    public Long updateReply(Long id, ReplyRequestDto replyRequestDto){
        Reply reply = replyRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        reply.update(replyRequestDto);
        return reply.getId();
    }

}