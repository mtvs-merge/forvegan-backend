package com.ohgiraffers.forepeproject.member.command.application.service;


import com.ohgiraffers.forepeproject.member.command.application.dto.MemberDTO;
import com.ohgiraffers.forepeproject.member.query.domain.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.lang.reflect.Member;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @PutMapping("/registMember")
    public MemberDTO registMember(MemberDTO memberDTO) {

        memberRepository.save(modelMapper.map(memberDTO, Member.class));

        Member result = memberRepository.findByMember(memberDTO.getMemberNum()).get(0);

        return modelMapper.map(result, MemberDTO.class);
    }
}

