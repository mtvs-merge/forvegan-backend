package com.ohgiraffers.forepeproject.post.command.application.controller;


import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostUpdateDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostDeleteService;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/post/update")
public class PostUpdateController {

    private final PostDeleteService postDeleteService;

    @Autowired
    public PostUpdateController(PostDeleteService postDeleteService, PostRepository postRepository){
        this.postDeleteService = postDeleteService;
    }


    @PostMapping("/row")
    public String UpdatePost(@RequestParam PostUpdateDTO postUpdateDTO, RedirectAttributes redirectAttributes) {

        // Check if owner
        if(PostUpdateService.isOwner(postUpdateDTO)) {
            try{
                PostUpdateService.deletePost(postUpdateDTO);
            } catch (Exception e){
                redirectAttributes.addFlashAttribute("message", "존재하지 않는 게시판입니다");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "게시판 작성자가 아닙니다");
        }


        return "redirect:/post";

    }

}
