package com.ohgiraffers.forepeproject.member.command.application.service;


import com.ohgiraffers.forepeproject.member.command.application.dto.MemberDTO;
import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.forepeproject.member.query.domain.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
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


}

