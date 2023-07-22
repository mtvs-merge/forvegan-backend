package com.ohgiraffers.forepeproject.member.command.application.controller;

import com.ohgiraffers.forepeproject.common.ResponseDto;
import com.ohgiraffers.forepeproject.member.command.application.dto.MemberDTO;
import com.ohgiraffers.forepeproject.member.command.application.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "api/v1", produces = "application/json;charset=UTF-8")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/members")
    public ResponseEntity<ResponseDto> findMemberList() {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 조회 성공!", memberService.findMemberList()));
    }

    @GetMapping("/members/{socialLogin}/{socialid}")
    public ResponseEntity<ResponseDto> findBySocialid(@PathVariable String socialLogin, @PathVariable String socialId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        MemberDTO foundMember = memberService.findBySocialId(socialLogin, socialId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("member", foundMember);

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "소셜 아이디 검색 성공!", responseMap));
    }


}
