package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.forepeproject.post.command.application.service.CommentCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentCheckController {
    private final CommentCheckService commentCheckService;

    @Autowired
    public CommentCheckController(CommentCheckService commentCheckService) {
        this.commentCheckService = null;
    }

    @GetMapping
    public List<CommentEntity> getAllComment(){
        return commentCheckService.getAllComments();
    }
}
