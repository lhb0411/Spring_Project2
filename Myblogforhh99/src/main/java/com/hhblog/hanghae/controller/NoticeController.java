package com.hhblog.hanghae.controller;

import com.hhblog.hanghae.domain.Notice;
import com.hhblog.hanghae.domain.NoticeRepository;
import com.hhblog.hanghae.domain.NoticeRequestDto;
import com.hhblog.hanghae.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeController {

    private final NoticeRepository noticeRepository;
    private final NoticeService noticeService;

    @PostMapping("/api/notices")
    public Notice createNotice(@RequestBody NoticeRequestDto requestDto) {
        Notice notice = new Notice(requestDto);
        return noticeRepository.save(notice);
    }

    @GetMapping("/api/notices")
    public List<Notice> getNotice() {
        return noticeRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/notices/{id}")
    public Long updateNotice(@PathVariable Long id, @RequestBody NoticeRequestDto requestDto) {
        noticeService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/notices/{id}")
    public Long deleteNotice(@PathVariable Long id) {
        noticeRepository.deleteById(id);
        return id;
    }
}