package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/update")
public class PostModifyController {

    private final PostModifyService postModifyService;

    @Autowired
    PostModifyController(PostModifyService postModifyService) {
        this.postModifyService = postModifyService;
    }

    @PostMapping("/all")
    public String updatePost(@RequestParam PostDTO postDTO, RedirectAttributes redirectAttributes) {

        if(postModifyService.verifyOwner(postDTO)) {
            postModifyService.updatePost(postDTO);
        } else {
            redirectAttributes.addFlashAttribute("message", "게시판 작성자가 아닙니다");
        }

        return "redirect:/post";

    }
}
