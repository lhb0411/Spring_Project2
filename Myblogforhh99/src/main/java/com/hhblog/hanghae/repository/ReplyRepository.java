package com.hhblog.hanghae.repository;
import com.hhblog.hanghae.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>  {
    @Query(value = "SELECT * FROM reply r WHERE r.notice_id = :notice_id order by modified_at desc", nativeQuery = true)
    List<Reply> findByArticleIdOrderByModifiredAtDesc(@Param(value = "notice_id") Long notice_id);
}