package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostCreateService;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.postAttachment.command.application.service.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostCreateController {
    private final PostCreateService postCreateService;

    public PostCreateController(PostCreateService postCreateService) {
        this.postCreateService = postCreateService;
    }

    @PostMapping
    public String createPost(@ModelAttribute("createDTO") PostCreateDTO createDTO, @RequestParam("file")List<MultipartFile> files, RedirectAttributes redirectAttributes) {

        PostEntity postEntity = new PostEntity();

        BeanUtils.copyProperties(createDTO, postEntity);

        postCreateService.createPost(postEntity);
        FileUtils fileUtils = new FileUtils();
        fileUtils.log("이것도안되나"+files.get(0).getSize());

        redirectAttributes.addAttribute("postNum", postEntity.getPostNum());
        redirectAttributes.addFlashAttribute("files",files);
//        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
//        return "redirect:/post";
//        return "/attachment/saves";
        return "redirect:attachment/save";
    }



    public static class Post {
        public void setPostDetail(String postDetail) {
        }

        public void setPostName(String postName) {
        }

        public String getPostDetail() {
            return null;
        }

        public String getPostName() {
            return null;
        }
    }
}