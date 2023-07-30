package com.ohgiraffers.forepeproject.post.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostUpdateDTO {

    private String postName;
    private String postHighlight;
    private String postState;
    private String postDetail;
    private int postCategoryNum;
    private String attachment;

    public PostUpdateDTO(String postName, String postHighlight, String postState, String postDetail, int postCategoryNum, String attachment) {
        this.postName = postName;
        this.postHighlight = postHighlight;
        this.postState = postState;
        this.postDetail = postDetail;
        this.postCategoryNum = postCategoryNum;
        this.attachment = attachment;
    }
}
