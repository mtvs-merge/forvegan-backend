package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostCreateService;
import com.ohgiraffers.forepeproject.post.command.application.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RestController
public class PostCreateController {

    @Autowired
    private PostCreateService postCreateService;

//    public PostCreateController(PostCreateService postCreateService){
//        this.postCreateService = postCreateService;
//    }

    @GetMapping("/")
    public String List(){
        return "post/list.html";
    }

    @GetMapping("/post")
    public String create(){
        return "post/create.html";
    }

//    @PostMapping("/post")
//    public String create(PostDTO postDTO){
//        PostCreateService.savePost(postDTO);
//        return "redirect:/";
//    }
}

//
//    private PostCreateService postCreateService;
//
//    public PostCreateController(PostCreateService postCreateService){
//        this.postCreateService = postCreateService;
//    }
//
//    @GetMapping("/create")
//    public String createPostForm(Model model){
//        model.addAttribute("PostCreateDTO", new PostCreateDTO());
//        return "create";
//    }
//
//    @PostMapping("/create")
//    public String createPostForm(@ModelAttribute PostCreateDTO postCreateDTO){
//        postCreateService.savePost(postCreateDTO);
//        return "redirect:/list";
//        // 새로운 게시물을 생성한다면, 게시물 목록 페이지로 이동한다.
//    }
