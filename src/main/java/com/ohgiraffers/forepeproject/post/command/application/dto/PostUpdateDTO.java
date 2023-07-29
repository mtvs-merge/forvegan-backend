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
}
