package com.ohgiraffers.forepeproject.member.command.application.controller;

import com.ohgiraffers.forepeproject.common.ResponseDto;
import com.ohgiraffers.forepeproject.member.command.application.dto.MemberDTO;
import com.ohgiraffers.forepeproject.member.command.application.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    public ResponseEntity<ResponseDto> registMember(@RequestBody MemberDTO memberDTO) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED,"회원 등록 성공", memberService.registMember(memberDTO)));
    }
}
