package com.ohgiraffers.forepeproject.login.command.application.controller;


import com.ohgiraffers.forepeproject.jwt.TokenProvider;
import com.ohgiraffers.forepeproject.login.command.application.dto.AccessTokenDTO;
import com.ohgiraffers.forepeproject.login.command.application.dto.OauthTokenDTO;
import com.ohgiraffers.forepeproject.login.command.application.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    private final TokenProvider tokenProvider;


    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/index")
    public String main() { return "/index"; }




    @PreAuthorize("permitAll()")
    @ApiOperation(value = "카카오 인가 코드 받아와서 액세스 토큰 발급")
    @GetMapping("/auth/kakao/callback")
    public void getKakaoCode(@RequestParam("code") String code, HttpServletResponse response) {


        /* 인가 코드로 액세스 토큰 발급 */
        OauthTokenDTO oauthToken = loginService.getAccessToken(code);

        /* 액세스 토큰으로 DB 저장 or 확인 후 JWT 생성 */
        AccessTokenDTO jwtToken = loginService.getJwtToken(oauthToken);

        // JWT 토큰에서 memberNum 값 추출
        int memberNum = tokenProvider.getMemberNumFromToken(jwtToken.getAccessToken());

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("token", jwtToken);


        ResponseCookie jwtCookie = ResponseCookie.from("jwtToken", jwtToken.getAccessToken())
                .maxAge(3600)
                .secure(true)
                .sameSite("strict")
                .path("/")
                .build();

        ResponseCookie memberNumCookie = ResponseCookie.from("memberNum", String.valueOf(memberNum))
                        .maxAge(3600)
                        .secure(true)
                        .sameSite("strict")
                        .path("/")
                        .build();

        response.addHeader(HttpHeaders.SET_COOKIE, memberNumCookie.toString());
        response.addHeader(HttpHeaders.SET_COOKIE, jwtCookie.toString());

        /* JWT와 응답 결과를 프론트에 전달 */
        try {
            response.sendRedirect("http://localhost:8888");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/kakao-auth")
    public void sendKakaoAuthRequest(HttpServletResponse response) {
        String clientId = "94407d0193a445443e41394304ebfacd"; // 카카오 앱의 client_id
        String redirectUri = "http://localhost:8888/auth/kakao/callback"; // 설정된 리다이렉트 URI
        String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&response_type=code";

        try {
            response.sendRedirect(kakaoUrl);
        } catch (IOException e) {
            throw new RuntimeException("Failed to redirect to Kakao Auth URL", e);
        }
    }


    @ApiOperation(value = "jwt 액세스 토큰 만료되어 재발급")
    @PostMapping("/renew")
    public ResponseEntity<?> renewAccessToken(@RequestHeader(value = "Auth") String auth) {

        return null;
    }



}
