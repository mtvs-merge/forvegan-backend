package com.ohgiraffers.forepeproject.post.command.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class TempHomeController {

    @GetMapping("")
    public String home() {
        return "/index";
    }
}
