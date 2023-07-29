package com.ohgiraffers.forepeproject.like.command.application.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LikeDTO {

    private int commentNum;
    private String commentWriter;
    private int postNum;
    private String postWriter;
}
