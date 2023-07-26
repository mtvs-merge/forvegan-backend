package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDTO;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostModifyService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post/modify")
public class PostModifyController {

    private final PostModifyService postModifyService;

    @Autowired
    public PostModifyController(PostModifyService postModifyService) {
        this.postModifyService = postModifyService;
    }

    @PostMapping("/all")
    public String modifyPost(@RequestParam PostDTO postDTO, RequestParam requestParam) {

        PostEntity postEntity = new PostEntity();

        BeanUtils.copyProperties(postDTO, postEntity);

        postModifyService.modifyAll(postEntity);

        return "redirect:/post";
    }

}
