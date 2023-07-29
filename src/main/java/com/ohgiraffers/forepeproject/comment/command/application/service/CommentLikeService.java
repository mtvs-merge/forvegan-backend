//package com.ohgiraffers.forepeproject.comment.command.application.service;
//
//import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
//import com.ohgiraffers.forepeproject.comment.command.domain.repository.CommentRepository;
//import com.ohgiraffers.forepeproject.like.command.application.dto.CommentLikeDTO;
//import com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity.CommentLikeEntity;
//import org.apache.ibatis.javassist.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.xml.stream.events.Comment;
//
//@Service
//public class CommentLikeService {
//
//    private final CommentRepository commentRepository;
//    public Object removeComment;
//
//    @Autowired
//    public CommentLikeService(CommentRepository commentRepository) {
//        this.commentRepository = commentRepository;
//    }
//
//    public void likeComment(Long commentId) throws NotFoundException {
//        // commentId를 이용하여 데이터베이스에서 해당 댓글을 찾아서 공감 수를 증가시킵니다.
//        Comment comment = (Comment) commentRepository.findById(commentId)
//                .orElseThrow(() -> new NotFoundException("댓글을 찾을 수 없습니다."));
//        ((CommentEntity) comment).setCommentLike(((CommentEntity) comment).getCommentLike() + 1);
////        commentRepository.save(comment);
//    }
//
//    public void unlikeComment(Long commentId) throws NotFoundException {
//        // commentId를 이용하여 데이터베이스에서 해당 댓글을 찾아서 공감 수를 감소시킵니다.
//        Comment comment = (Comment) commentRepository.findById(commentId)
//                .orElseThrow(() -> new NotFoundException("댓글을 찾을 수 없습니다."));
//        if (((CommentEntity) comment).getCommentLike() > 0) {
//            ((CommentEntity) comment).setCommentLike(((CommentEntity) comment).getCommentLike() - 1);
////            commentRepository.save(comment);
//        }
//    }
//
//    public void addCommentLike(CommentLikeDTO commentLikeDTO) {
//    }
//
//    public void removeCommentLike(int commentLikeNum) {
//    }
//
//    public CommentLikeEntity getCommentLike(int commentLikeNum) {
//        return null;
//    }
//
//    public void addCommentLike(int commentNum, String commentWriter) {
//    }
//}
