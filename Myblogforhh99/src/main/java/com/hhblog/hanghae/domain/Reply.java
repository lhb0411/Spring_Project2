package com.hhblog.hanghae.domain;

import com.hhblog.hanghae.Dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long notice_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Comment (CommentRequestDto commentRequestDto){
        this.id = commentRequestDto.getId();
        this.notice_id = commentRequestDto.getNotice_id();
        this.username = commentRequestDto.getUsername();
        this.contents = commentRequestDto.getContents();
    }

    public void update_comment(CommentRequestDto commentRequestDto){
        this.notice_id = commentRequestDto.getNotice_id();
        this.username = commentRequestDto.getUsername();
        this.contents = commentRequestDto.getContents();
    }

}

