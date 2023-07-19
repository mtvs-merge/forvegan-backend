package com.ohgiraffers.forepeproject.post.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDTO {

    private int postNum;
    private int postLike;
    private String postName;
    private String postWriter;
    private String postHighlight;
    private String postState;
    private String postDate;
    private String postDetail;
    private int views;
    private int postCategoryNum;
    private String attachment;
    private int postMemberNum;
}

