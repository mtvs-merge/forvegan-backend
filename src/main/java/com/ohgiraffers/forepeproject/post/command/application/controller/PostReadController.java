package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.service.PostReadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "/vegan";
    }

    @GetMapping("/lactoovo")
    public String getLactoPost(@RequestParam(required = false, defaultValue = "1") int page, Model model) {
        model.addAttribute("currentPage", page);
        model.addAttribute("postList", postReadService.getAllPost(page, 2));
        return "/lactoovo";
    }

    @GetMapping("/pescopolo")
    public String getPescoPost(@RequestParam(required = false, defaultValue = "1") int page, Model model) {
        model.addAttribute("currentPage", page);
        model.addAttribute("postList", postReadService.getAllPost(page, 3));
        return "/pescopolo";
    }
}
