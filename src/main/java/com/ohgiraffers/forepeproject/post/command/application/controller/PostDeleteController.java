package com.ohgiraffers.forepeproject.post.command.application.controller;


import com.ohgiraffers.forepeproject.post.command.application.service.PostDeleteService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.enumType.ResponesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/post/delete")
public class PostDeleteController {

    private final PostDeleteService postDeleteService;

    @Autowired
    public PostDeleteController(PostDeleteService postDeleteService){
        this.postDeleteService = postDeleteService;
    }

    @PostMapping("/row")
    public ResponesEnum deletePost(@RequestParam Long postNum) {
        return postDeleteService.deletePost(postNum);
    }

}
