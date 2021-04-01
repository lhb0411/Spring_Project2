package com.hhblog.hanghae.service;

import com.hhblog.hanghae.domain.Notice;
import com.hhblog.hanghae.domain.Reply;
import com.hhblog.hanghae.repository.NoticeRepository;
import com.hhblog.hanghae.Dto.NoticeRequestDto;
import com.hhblog.hanghae.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final 쓸때 생성자 자동 생성
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class NoticeService {
    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    private final NoticeRepository noticeRepository;
    private final ReplyRepository replyRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, NoticeRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        notice.update(requestDto);
        return notice.getId();
    }
}