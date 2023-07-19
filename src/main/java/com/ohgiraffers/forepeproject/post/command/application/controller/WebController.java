package com.ohgiraffers.forepeproject.post.command.application.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class WebController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name", "내 이름");
        model.addAttribute("img", "image/imagesfilesss");
        return "hello";
    }

    @GetMapping("/new")
    public String newPost(){
        return "new";
    }

}
