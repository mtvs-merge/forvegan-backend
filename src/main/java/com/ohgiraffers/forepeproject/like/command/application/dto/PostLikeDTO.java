package com.ohgiraffers.forepeproject.like.command.application.dto;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostLikeDTO {

    private int postNum;
    private int postLikeNum;
    private String postWriter;
    private String postLikeUser;
}
