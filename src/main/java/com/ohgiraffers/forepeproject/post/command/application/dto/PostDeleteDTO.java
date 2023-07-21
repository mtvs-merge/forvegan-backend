package com.ohgiraffers.forepeproject.post.command.application.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDeleteDTO {

    private int postNum;
    private String postState;
    private String postDetail;
    private int postCategoryNum;
    private int postMemberNum;

}
