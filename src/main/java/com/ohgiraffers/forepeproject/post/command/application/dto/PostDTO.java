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
    private String postWriter;
    private String postHighlight;
    private String postShowState;
    private String postDate;
    private String postDetail;
    private int views;
    private int postCategoryNum;
    private String postAttachmentNum;
    private int postMemberNum;
}



