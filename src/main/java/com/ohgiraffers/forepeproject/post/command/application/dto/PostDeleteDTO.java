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
    private int postMemberNum;

    public PostDeleteDTO(int postNum, String postState, int postMemberNum) {
        this.postNum = postNum;
        this.postState = postState;
        this.postMemberNum = postMemberNum;
    }
}
