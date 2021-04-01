package com.hhblog.hanghae.domain;

import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {
    public static Specification<Comment> withArticle_id(Long notice_id) {
        return (Specification<Comment>) ((root, query, builder) ->
                builder.equal(root.get("notice_id"), notice_id)
        );
    }
}