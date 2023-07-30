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
    public String getVeganPost(@RequestParam(required = false, defaultValue = "1") int currentPage, Model model) {

//        setModelAttributes(currentPage, 1, model);

        String postCategory = "";
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("maxPage", postReadService.getMaxPage(1));

        model.addAttribute("postCategory", "vegan");
        model.addAttribute("postList", postReadService.getAllPost(currentPage, 1));

        return "/mytree";
    }

    @GetMapping("/lactoovo")
    public String getLactoPost(@RequestParam(required = false, defaultValue = "1") int currentPage, Model model) {

        setModelAttributes(currentPage, 2, model);

        return "/mytree";
    }

    @GetMapping("/pescopolo")
    public String getPescoPost(@RequestParam(defaultValue = "1") int currentPage, Model model) {

        setModelAttributes(currentPage, 3, model);

        return "/mytree";
    }

    private void setModelAttributes(int currentPage, int postCategoryNum, Model model) {
        String postCategory = "";
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("maxPage", postReadService.getMaxPage(postCategoryNum));
        switch (postCategoryNum){
            case 1:
                postCategory = "vegan";
                break;
            case 2:
                postCategory = "lactoovo";
                break;
            case 3:
                postCategory = "pescopolo";
                break;
        }
        model.addAttribute("postCategory", postCategory);
        model.addAttribute("postList", postReadService.getAllPost(currentPage, postCategoryNum));
    }

}

