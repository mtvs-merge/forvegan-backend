package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.service.PostUpdateService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.enumType.ResponesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post/update")
public class PostUpdateController {

    private final PostUpdateService postUpdateService;

    @Autowired
    public PostUpdateController(PostUpdateService postUpdateService){
        this.postUpdateService = postUpdateService;
    }

//    @PostMapping("/row")
//    public ResponesEnum updatePost(@RequestParam Long postNum) {
//        return postUpdateService.updatePost(postNum);
//    }
}