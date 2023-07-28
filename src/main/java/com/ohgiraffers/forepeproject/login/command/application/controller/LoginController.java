//package com.ohgiraffers.forepeproject.login.command.application.controller;
//
//
//import com.ohgiraffers.forepeproject.common.ResponseDto;
//import com.ohgiraffers.forepeproject.login.command.application.dto.AccessTokenDTO;
//import com.ohgiraffers.forepeproject.login.command.application.dto.OauthTokenDTO;
//import com.ohgiraffers.forepeproject.login.command.application.service.LoginService;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Controller
//@RequestMapping("/api/v1/login")
//public class LoginController {
//
//    private final LoginService loginService;
//
//    @Autowired
//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }
//
//    @PreAuthorize("permitAll()")
//    @ApiOperation(value = "카카오 인가 코드 받아와서 액세스 토큰 발급")
//    @PostMapping("/kakaoCode")
//    public ResponseEntity<?> getKakaoCode(@RequestBody Map<String, String> code) {
//
//        /* 인가 코드로 액세스 토큰 발급 */
//        OauthTokenDTO oauthToken =loginService.getAccessToken(code.get("code"));
//
//        /* 액세스 토큰으로 DB 저장 or 확인 후 JWT 생성 */
//        AccessTokenDTO jwtToken = loginService.getJwtToken(oauthToken);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("token", jwtToken);
//
//        /* JWT와 응답 결과를 프론트에 전달 */
//        return ResponseEntity
//                .ok()
//                .body(new ResponseDto(HttpStatus.OK, "로그인 성공", responseMap));
//    }
//
//    @ApiOperation(value = "jwt 액세스 토큰 만료되어 재발급")
//    @PostMapping("/renew")
//    public ResponseEntity<?> renewAccessToken(@RequestHeader(value = "Auth") String auth) {
//
//        return null;
//    }
//
//}
