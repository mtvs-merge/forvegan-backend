package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.common.ResponseDto;
import com.ohgiraffers.forepeproject.post.command.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller = View로부터 오는 API 요청을 어떻게 처리할 것인지!


// Create = post / 서버에 정보 올려달라는 요청
// Read - 서버에서 정보를 불러오는 요청
// Update - 정보 바꾸기
// Delete - 정보 삭제

@Controller
@RestController
@RequiredArgsConstructor   // Bean 주입 : @Autowired 대신에 생성자로!
@RequestMapping("/vegan")

public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/list.do")
    public String main(Model model) {
        return "main";
    }


}

//    @GetMapping("/")
//    public String vagan(){
//        return "vegan";
//    }
//
//    @GetMapping("/vegan")
//    public String vegan(){
//        return"write";
//    }
//
//    @PostMapping("/vegan")                  // 여기로 요청이 들어오면
//    public String vegan(PostDTO postDTO){      // DTO에 내용을 담겨 넘어온다
//        postService.savePost(postDTO);         // PostService의 save 메소드로 넘겨준다.
//        return "redirect:/write";
//    }
//
//    @GetMapping("/write")
//    public String write(){
//        return "vegan";
//    }
//
//    @GetMapping("/view")
//    public String view(){
//        return
//    }

//}
