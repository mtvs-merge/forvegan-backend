package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.forepeproject.comment.command.domain.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentCheckService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentCheckService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentEntity> getAllComments() {
        return commentRepository.findAll();
    }
}
