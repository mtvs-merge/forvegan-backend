package com.ohgiraffers.forepeproject.comment.command.application.controller;

import com.ohgiraffers.forepeproject.comment.command.application.dto.CommentDTO;
import com.ohgiraffers.forepeproject.comment.command.application.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String createComment(@RequestBody CommentDTO commentDTO) {
//        Comment createdComment = (Comment) commentService.createComment(commentDTO);
        return "/post";
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> readComment(@PathVariable Integer id) {
        CommentDTO commentDTO = commentService.readComment(id);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public String updateComment(@PathVariable Integer id, @RequestBody CommentDTO commentDTO) {
        commentService.updateComment(id, commentDTO);
        return "/post";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
