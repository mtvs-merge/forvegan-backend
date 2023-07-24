package com.ohgiraffers.forepeproject.comment.command.application.service;

import com.ohgiraffers.forepeproject.comment.command.application.dto.CommentDTO;
import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.forepeproject.comment.command.domain.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.xml.stream.events.Comment;

@Service
public class CommentService {
    private final CommentsRepository commentsRepository;

    public CommentService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comment createComment(CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentDetail(commentDTO.getComments());

        return commentsRepository.save(commentEntity);
    }

    public CommentDTO readComment(Long id) {
        CommentEntity commentEntity = (CommentEntity) commentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentWriter(commentEntity.getCommentDetail());
        commentDTO.setCommentNum(commentEntity.getCommentPostNum());

        return commentDTO;
    }

    public Comment updateComment(Long id, CommentDTO commentDTO) {
        CommentEntity commentEntity = (CommentEntity) commentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));

        commentEntity.setCommentNum(commentDTO.getCommentNum());

        return commentsRepository.save(commentEntity);
    }

    public void deleteComment(Long id) {
        CommentEntity commentEntity = (CommentEntity) commentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));

        commentsRepository.delete(commentEntity);
    }
}
