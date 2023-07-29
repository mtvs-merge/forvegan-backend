package com.ohgiraffers.forepeproject.member.command.application.controller;

import com.ohgiraffers.forepeproject.common.ResponseDto;
import com.ohgiraffers.forepeproject.member.command.application.service.MemberService;
import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/{memberNum")
    public ModelAndView findMemberByNum(@PathVariable int memberNum) {
        MemberEntity member = memberService.findMemberByNum(memberNum);
        ModelAndView mav = new ModelAndView("member-info");
        mav.addObject("member", member);
        return mav;
    }
    

}
