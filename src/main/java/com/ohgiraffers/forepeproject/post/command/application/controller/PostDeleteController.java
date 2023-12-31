package com.ohgiraffers.forepeproject.post.command.application.controller;


import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostDeleteService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/post/delete")
public class PostDeleteController {

    private final PostDeleteService postDeleteService;

    @Autowired
    public PostDeleteController(PostDeleteService postDeleteService, PostRepository postRepository){
        this.postDeleteService = postDeleteService;
    }


    @PostMapping("/{postNum}")
    public String deletePost(@PathVariable int postNum, RedirectAttributes redirectAttributes) {

//        PostDeleteDTO postDeleteDTO = new PostDeleteDTO();

        // Check if owner
        /*if(postDeleteService.isOwner(postDeleteDTO)) {
            try{
                postDeleteService.deletePost(postDeleteDTO);
            } catch (Exception e){
                redirectAttributes.addFlashAttribute("message", "존재하지 않는 게시판입니다");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "게시판 작성자가 아닙니다");
        }*/
        redirectAttributes.addFlashAttribute("postNum",postNum);
        postDeleteService.deletePost(postNum);

        return "redirect:/attachment/delete";

    }

}
