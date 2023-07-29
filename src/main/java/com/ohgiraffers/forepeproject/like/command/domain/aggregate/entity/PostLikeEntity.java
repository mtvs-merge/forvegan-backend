package com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity;

import com.ohgiraffers.forepeproject.like.command.domain.aggregate.vo.CommentWriter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "postLike")
@Table(name = "POST_LIKE")
@SequenceGenerator(
        name = "POST_SEQ_GENERATOR",
        sequenceName = "SEQ_POST_NUM",
        initialValue = 1,
        allocationSize = 1
)
public class PostLikeEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "POST_SEQ_GENERATOR"
    )
    @Column(name = "POST_NUM")
    private int postNum;

    @Column(name = "POST_TITLE")
    private String postTitle;

    @Column(name = "POST_CONTENT")
    private String postContent;

    @Column(name = "POST_DATE")
    private String postDate;

    @Embedded
    @Column(name = "POST_WRITER")
    private CommentWriter postWriter;


    @PrePersist
    public void onPrePersist() {
        this.postDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setPostWriter(String postWriter) {
    }
}
