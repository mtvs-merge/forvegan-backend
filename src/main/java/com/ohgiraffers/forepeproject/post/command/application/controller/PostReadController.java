package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.service.PostReadService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostReadController {
    private final PostReadService postReadService;

    public PostReadController(PostReadService postReadService) {
        this.postReadService = postReadService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PostCreateController.Post> readPost(@PathVariable Long id) {
//        PostCreateController.Post post = postReadService.readPost(id);
//        return new ResponseEntity<>(post, HttpStatus.OK);
//    }

    @GetMapping("/vegan")
    public String getVeganPost(@RequestParam(required = false, defaultValue = "1") int page, Model model) {
        model.addAttribute("currentPage", page);
        model.addAttribute("postList", postReadService.getAllPost(page, 1));
        return "/mytree";
    }

    @GetMapping("/lactoovo")
    public String getLactoPost(@RequestParam(required = false, defaultValue = "1") int page, Model model) {
        model.addAttribute("currentPage", page);
        model.addAttribute("postList", postReadService.getAllPost(page, 2));
        return "/mytree";
    }

    @GetMapping("/pescopolo")
    public String getPescoPost(@RequestParam(required = false, defaultValue = "1") int page, Model model) {
        model.addAttribute("currentPage", page);
        model.addAttribute("postList", postReadService.getAllPost(page, 3));
        return "/mytree";
    }
}

