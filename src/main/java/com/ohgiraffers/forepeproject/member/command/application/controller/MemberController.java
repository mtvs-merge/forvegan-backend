package com.ohgiraffers.forepeproject.member.command.application.controller;

import com.ohgiraffers.forepeproject.jwt.CookieUtil;
import com.ohgiraffers.forepeproject.member.command.application.dto.MemberDTO;
import com.ohgiraffers.forepeproject.member.command.application.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final CookieUtil cookieUtil;

    @Autowired
    public MemberController(MemberService memberService, CookieUtil cookieUtil) {
        this.memberService = memberService;
        this.cookieUtil = cookieUtil;
    }

    @GetMapping("/getMemberInfo")
    public String getMemberInfo(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        int memberNum = cookieUtil.getCookieValue(request);
        MemberDTO member = memberService.findMemberByNum(memberNum);

        redirectAttributes.addAttribute("memberNickName", member.getMemberNickname());
        redirectAttributes.addAttribute("socialLogin", member.getSocialLogin());

        return "redirect:/editnickname";
    }

    @GetMapping("/editnickname")
    public ModelAndView editNickname(@RequestParam(name = "memberNickName", required = false) String memberNickName,
                                     @RequestParam(name = "socialLogin", required = false) String socialLogin) {
        ModelAndView mav = new ModelAndView("editnickname");
        mav.addObject("memberNickName", memberNickName);
        mav.addObject("socialLogin", socialLogin);
        return mav;
    }

    @PostMapping("/updateNickname")
    public String updateNickname(HttpServletRequest request, @RequestParam String nickname) {
        int memberNum = cookieUtil.getCookieValue(request);
        memberService.updateNickname(memberNum, nickname);
        return "redirect:/getMemberInfo";
    }

    @PostMapping("/deleteMember")
    public String deleteMember(HttpServletRequest request, HttpServletResponse response) {

        int memberNum =cookieUtil.getCookieValue(request);
        memberService.deleteMember(memberNum);

        Cookie memberNumCookie = new Cookie("memberNum", null);

        memberNumCookie.setMaxAge(0);
        response.addCookie(memberNumCookie);

        Cookie jwtCookie = new Cookie("jwtToken", null);

        jwtCookie.setMaxAge(0);
        jwtCookie.setPath("/");

        response.addCookie(jwtCookie);

        return "redirect:/index";

    }

    @GetMapping("/deleteaccount")
    public String showDeleteConfirmPage() {
        return "deleteaccount";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie memberNumCookie = new Cookie("memberNum", null); // 이름이 "memberNum"인 쿠키 생성
        memberNumCookie.setMaxAge(0); // 쿠키의 유효 시간을 0으로 설정
        memberNumCookie.setPath("/"); // 쿠키 경로 설정. 일반적으로 루트 경로로 설정
        response.addCookie(memberNumCookie); // 쿠키 추가

        return "redirect:/login"; // 로그아웃 후 로그인 페이지로 리다이렉트
    }

}

