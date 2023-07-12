package com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Post")
@Table(name = "POST")
@SequenceGenerator(
        name = "POST_SEQ_GENERATOR",
        sequenceName = "SEQ_POST_NUM",
        initialValue = 1,
        allocationSize = 1
)
public class PostEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "POST_SEQ_GENERATOR"
    )
    @Column(name = "POST_NUM")
    private int postNum;
    @Column(name = "POST_LIKE")
    private int postLike;
    @Column(name = "POST_NAME")
    private String postName;
    @Column(name = "POST_WRITER")
    private String postWriter;
    @Column(name = "POST_HIGHLIGHT")
    private String postHighlight;
    @Column(name = "POST_STATE")
    private String postState;
    @Column(name = "POST_DATE")
    private String postDate;
    @Column(name = "POST_DETAIL")
    private String postdetail;
    @Column(name = "VIEWS")
    private int views;
    @Column(name = "POST_CATEGORY_NUM")
    private int postCategoryNum;
    @Column(name = "ATTACHMENT")
    private String attachment;
    @Column(name = "POST_MEMBER_NUM")
    private int postMemberNum;

    @PrePersist
    public void onPrePersist() { this.postDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); }
}
