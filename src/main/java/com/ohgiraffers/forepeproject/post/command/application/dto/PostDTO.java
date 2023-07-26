package com.ohgiraffers.forepeproject.post.command.application.dto;

import lombok.*;

// dto = controller와 service에서 사용됨
//       ㄴ 화면에서 직접 받고, 넘기는 객체!
//       ㄴ 요청 데이터를 수신한다.

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDTO {

    private int postNum;
    private String postName;
    private int postLike;
    private String postWriter;
    private String postHighlight;
    private String postShowState;
    private String postDate;
    private String postDetail;
    private int views;
    private int postCategoryNum;
    private String postAttachmentNum;
    private int postMemberNum;

    public PostDTO(int postNum, String postName, int postLike, String postWriter, String postHighlight, String postShowState, String postDate, String postDetail, int views, int postCategoryNum, String postAttachmentNum, int postMemberNum) {
        this.postNum = postNum;
        this.postName = postName;
        this.postLike = postLike;
        this.postWriter = postWriter;
        this.postHighlight = postHighlight;
        this.postShowState = postShowState;
        this.postDate = postDate;
        this.postDetail = postDetail;
        this.views = views;
        this.postCategoryNum = postCategoryNum;
        this.postAttachmentNum = postAttachmentNum;
        this.postMemberNum = postMemberNum;
    }
}



