package com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    private int postNum;
    private int postLike;
    private String postName;
    private String postWriter;
    private String postHighlight;
    private String postState;
    private String postDate;
    private String postdetail;
    private int views;
    private int categoryNum;
    private String attachment;
    private int MemberNum;
}
