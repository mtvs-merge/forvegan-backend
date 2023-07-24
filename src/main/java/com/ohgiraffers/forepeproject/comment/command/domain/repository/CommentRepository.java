package com.ohgiraffers.forepeproject.comment.command.domain.repository;

        import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import javax.xml.stream.events.Comment;
@Repository
interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}

