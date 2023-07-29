package com.ohgiraffers.forepeproject.login.command.application.controller;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.forepeproject.common.ResponseDto;
import com.ohgiraffers.forepeproject.login.command.application.dto.AccessTokenDTO;
import com.ohgiraffers.forepeproject.login.command.application.dto.KakaoProfileDTO;
import com.ohgiraffers.forepeproject.login.command.application.dto.OauthTokenDTO;
import com.ohgiraffers.forepeproject.login.command.application.service.LoginService;
import com.ohgiraffers.forepeproject.member.command.application.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Api(tags = "로그인 API")
@RequiredArgsConstructor
@Slf4j
@Controller
public class LoginController {

    private final LoginService loginService;


    @GetMapping("/auth/login")
    public String login() {
        return "user/login";
    }



    @PreAuthorize("permitAll()")
    @ApiOperation(value = "카카오 인가 코드 받아와서 액세스 토큰 발급")
    @GetMapping("/auth/kakao/callback")
    public void getKakaoCode(@RequestParam("code") String code, HttpServletResponse response) {

        /* 인가 코드로 액세스 토큰 발급 */
        OauthTokenDTO oauthToken = loginService.getAccessToken(code);

        /* 액세스 토큰으로 DB 저장 or 확인 후 JWT 생성 */
        AccessTokenDTO jwtToken = loginService.getJwtToken(oauthToken);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("token", jwtToken);


        ResponseCookie cookie = ResponseCookie.from("jwtToken", jwtToken.getAccessToken())
                .maxAge(3600)
                .secure(true)
                .sameSite("strict")
                .path("/")
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        /* JWT와 응답 결과를 프론트에 전달 */
        try {
            response.sendRedirect("http://localhost:8888");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "jwt 액세스 토큰 만료되어 재발급")
    @PostMapping("/renew")
    public ResponseEntity<?> renewAccessToken(@RequestHeader(value = "Auth") String auth) {

        return null;
    }

}
