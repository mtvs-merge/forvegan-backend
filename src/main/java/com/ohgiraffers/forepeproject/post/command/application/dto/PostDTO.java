package com.ohgiraffers.forepeproject.post.command.application.dto;

import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
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

    public static Object toEntity() {
        return null;
    }

    public PostRepository save(Object entity) {
        PostRepository postRepository = null;
        return postRepository;
    }
}



