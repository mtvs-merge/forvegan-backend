package com.ohgiraffers.forepeproject.comment.command.domain.repository;

import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;
import java.util.Optional;

@Repository
public class CommentsRepository {
    public Optional<Object> findById() {
        return null;
    }

    public Comment save(CommentEntity commentEntity) {
        return null;
    }

    public Comment delete(CommentEntity commentEntity) {
        return null;
    }
}