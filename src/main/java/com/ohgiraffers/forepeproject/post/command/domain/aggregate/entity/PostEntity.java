package com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity;

import com.ohgiraffers.forepeproject.post.command.application.controller.PostCheckController;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Entity 클래스는 Table 혹은 Record 역할을 하는 DB 그 자체
// 절대 요청 혹은 응답에 사용되어선 안되기 때문에 Response, Request 클래스는 따로 생성


@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Post")
@Table(name = "POST")
@SequenceGenerator(
        name = "POST_SEQ_GENERATOR",
        sequenceName = "SEQ_POST_NUM",
        initialValue = 1,
        allocationSize = 1
)
public class PostEntity<P> {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "POST_SEQ_GENERATOR"
    )

    @Column(name = "POST_NUM", nullable = false)
    private int postNum;

    @Column(name = "POST_NAME", length = 20, nullable = false)
    private String postName;

    @Column(name = "POST_LIKE")
    private int postLike;

    @Column(name = "POST_WRITER", nullable = false)
    private String postWriter;

    @Column(name = "POST_HIGHLIGHT")
    private String postHighlight;

    @Column(name = "POST_STATE")
    private String postState;

    @Column(name = "POST_DATE", nullable = false)
    private String postDate;

    @Column(name = "POST_DETAIL",
            columnDefinition = "TEXT", nullable = false)
    private String postDetail;

    @Column(name = "VIEWS")
    private int views;

    @Column(name = "POST_CATEGORY_NUM",nullable = false)
    private int postCategoryNum;

    @Column(name = "ATTACHMENT")
    private String attachment;

    @Column(name = "POST_MEMBER_NUM")
    private int postMemberNum;

//    public PostEntity(PostCheckController.Post post, HttpStatus httpStatus) {
//    }


//    @CreatedDate
//    @Column(name ="POST_CREATED_DATE", updatable = false)
//    private LocalDateTime createdDate;
//
//    @LastModifiedDate
//    @Column(name="POST_MODIFIED_DATE")
//    private LocalDateTime modifiedDate;

    @PrePersist // DB에 해당 테이블의 insert 연산을 실행할 때, 같이 실행하세요.
    public void onPrePersist() {
        this.postDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); }

//    @Builder
//    public PostEntity (int postNum, int postLike, String postName, String postWriter, String postHighlight,
//                       String postState, String postDate, String postDetail, int views,
//                       int postCategoryNum, String attachment, int postMemberNum){
//        this.postNum = postNum;
//        this.postLike = postLike;
//        this.postName = postName;
//        this.postWriter = postWriter;
//        this.postDetail = postDetail;
//        this.views = views;
//        this.postWriter = postWriter;
//        this.postCategoryNum = postCategoryNum;
//        this.postMemberNum = postMemberNum;
//    }


    @Builder
    public PostEntity(int postNum, String postName, int postLike, String postWriter, String postHighlight, String postState, String postDate, String postDetail, int views, int postCategoryNum, String attachment, int postMemberNum) {
        this.postNum = postNum;
        this.postName = postName;
        this.postLike = postLike;
        this.postWriter = postWriter;
        this.postHighlight = postHighlight;
        this.postState = postState;
        this.postDate = postDate;
        this.postDetail = postDetail;
        this.views = views;
        this.postCategoryNum = postCategoryNum;
        this.attachment = attachment;
        this.postMemberNum = postMemberNum;
    }
}
