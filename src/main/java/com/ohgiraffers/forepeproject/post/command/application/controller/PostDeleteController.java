package com.ohgiraffers.forepeproject.post.command.application.controller;


import com.ohgiraffers.forepeproject.post.command.application.service.PostDeleteService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/post/delete")
public class PostDeleteController {

    private final PostDeleteService postDeleteService;
    private final PostRepository postRepository;

    @Autowired
    public PostDeleteController(PostDeleteService postDeleteService, PostRepository postRepository){
        this.postDeleteService = postDeleteService;
        this.postRepository = postRepository;
    }


    @PostMapping("/row")
    public String deletePost(@RequestParam Long postNum, @RequestParam int postMemberNum, RedirectAttributes redirectAttributes) {

        PostEntity e = postRepository.findByPostNum(postMemberNum);

        if(postMemberNum == e.getPostMemberNum()){
            try {
                postDeleteService.deletePost(postNum);
            } catch (Exception exception) {
                redirectAttributes.addFlashAttribute("message", "존재하지 않는 게시판입니다");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "게시판 작성자가 아닙니다");
        }


        return "redirect:/post";

    }

}
