package com.ohgiraffers.forepeproject.member.command.application.service;


import com.ohgiraffers.forepeproject.jwt.CookieUtil;
import com.ohgiraffers.forepeproject.member.command.application.dto.MemberDTO;
import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.forepeproject.member.query.domain.repository.MemberMapper;
import com.ohgiraffers.forepeproject.member.query.domain.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final MemberMapper memberMapper;
//    private final JwtUtil jwtUtil;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.memberMapper = memberMapper;
    }
    public List<MemberDTO> findMemberList() {

        List<MemberEntity> memberList = memberRepository.findAll();

        return memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    public MemberDTO findBySocialId(String socialLogin, long socialId) {
        MemberEntity foundMember = memberRepository.findBySocialId(socialLogin, socialId);

        if (foundMember == null) {
            return null;
        } else {
            return modelMapper.map(foundMember, MemberDTO.class);
        }
    }

    @Transactional
    public long registNewUser(MemberDTO newMember) {

        newMember.setMemberNickname("새로운회원" +(Math.random() * 100 + 1));

        return memberRepository.save(modelMapper.map(newMember, MemberEntity.class)).getMemberNum();
    }


    public MemberDTO findMemberByNum(int memberNum) {

       MemberEntity member = memberRepository.findByMemberNum(memberNum);

       return convertToDTO(member);
    }

    private MemberDTO convertToDTO(MemberEntity entity) {
        MemberDTO dto = new MemberDTO();
        dto.setMemberNum(entity.getMemberNum());
        dto.setMemberNickname(entity.getMemberNickName());
        dto.setSocialLogin(entity.getSocialLogin());

        return dto;
    }

    public void updateNickname(int memberNum, String newNickname) {
        MemberEntity member = memberRepository.findByMemberNum(memberNum);
        if(member != null) {
            member.setMemberNickName(newNickname);
            memberRepository.save(member);
        } else {
            throw new RuntimeException("회원 정보가 존재하지 않습니다.");
        }

    }

    public void deleteMember(int memberNum) {

        MemberEntity member = memberRepository.findByMemberNum(memberNum);
        if (member != null) {
            memberRepository.delete(member);
        }
    }
}

