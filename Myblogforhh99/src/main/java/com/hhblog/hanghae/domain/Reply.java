package com.hhblog.hanghae.domain;

import com.hhblog.hanghae.Dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Reply extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long article_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Comment (ReplyRequestDto replyRequestDto){
        this.id = replyRequestDto.getId();
        this.article_id = replyRequestDto.getArticle_id();
        this.username = replyRequestDto.getUsername();
        this.contents = replyRequestDto.getContents();
    }

    public void update_comment(ReplyRequestDto replyRequestDto){
        this.article_id = replyRequestDto.getArticle_id();
        this.username = replyRequestDto.getUsername();
        this.contents = replyRequestDto.getContents();
    }

}

