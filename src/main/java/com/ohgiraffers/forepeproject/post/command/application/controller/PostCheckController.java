package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.service.PostCheckService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostCheckController {

    private final PostCheckService postCheckService;

    @Autowired
    public PostCheckController(PostCheckService postCheckService) {
        this.postCheckService = postCheckService;
    }


    @PostMapping("/createPost")
    public Post createPost(@RequestParam Post post) {
        return postCheckService.save(post);
    }


    @GetMapping("/{postNum}")
    public String getPostDetails(@PathVariable int postNum, Model model){
        model.addAttribute("postEntity", postCheckService.checkPost(postNum));
        return "/view";
    }

    public class Post {
    }
}

