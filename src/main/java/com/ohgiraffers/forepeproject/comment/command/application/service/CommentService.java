package com.ohgiraffers.forepeproject.comment.command.application.service;

import com.ohgiraffers.forepeproject.comment.command.application.dto.CommentDTO;
import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.forepeproject.comment.command.domain.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void createComment(CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentDetail(commentDTO.getComments());

        commentRepository.save(commentEntity);
    }

    public CommentDTO readComment(Integer id) {
        CommentEntity commentEntity = (CommentEntity) commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentWriter(commentEntity.getCommentDetail());
        commentDTO.setCommentNum(commentEntity.getCommentPostNum());

        return commentDTO;
    }

    public void updateComment(Integer id, CommentDTO commentDTO) {
        CommentEntity commentEntity = (CommentEntity) commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));

        commentEntity.setCommentNum(commentDTO.getCommentNum());

        commentRepository.save(commentEntity);
    }

    public void deleteComment(Integer id) {
        CommentEntity commentEntity = (CommentEntity) commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));

        commentRepository.delete(commentEntity);
    }

    public void updateComment(Long commentNum) {
    }
}
