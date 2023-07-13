package com.ohgiraffers.forepeproject.login.command.application.controller;


import com.ohgiraffers.forepeproject.login.command.application.dto.OauthTokenDTO;
import com.ohgiraffers.forepeproject.login.command.application.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping("/api/kakao")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PreAuthorize("permitAll()")
    @ApiOperation(value = "카카오 인가 코드 받아와서 액세스 토큰 발급")
    @PostMapping("/kakaoCode")
    public ResponseEntity<?> getKakaoCode(@RequestBody Map<String, String> code) {

        OauthTokenDTO oauthToken =loginService.getAccessToken(code.get("code"));
    }


}
