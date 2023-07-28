
package com.ohgiraffers.forepeproject.member.command.application.service;
/**

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.forepeproject.member.command.application.dto.MemberDTO;
import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.forepeproject.member.query.domain.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    private final ObjectMapper objectMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper,
                         ObjectMapper objectMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public List<MemberDTO> findMemberList() {

        List<MemberEntity> memberList = memberRepository.findAll();

        return memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }

    public MemberDTO findBySocialId(String socialLogin, String socialId) {

        MemberEntity foundMember = memberRepository.findBySocialId(socialLogin, Long.parseLong(socialId));

        if (foundMember == null) {
            return null;
        } else {
            return modelMapper.map(foundMember, MemberDTO.class);
        }
    }

    @Transactional
    public long registNewUser(MemberDTO newMember) {

        newMember.setMemberNickname("새로운회원" + (Math.random() * 100 + 1));

        return memberRepository.save(modelMapper.map(newMember, MemberEntity.class)).getMemberNum();
    }

    @Transactional
    public void modifyMember(MemberDTO modifyInfo, long memberNum, String type) {

        MemberEntity foundMember = memberRepository.findById(memberNum).get();

        switch (type) {
            case "edit":
                if (modifyInfo.getMemberNickname().length() > 0) {
                    foundMember.setMemberNickname(modifyInfo.getMemberNickname());
                }
                if (modifyInfo.getPreferredLocation().length() > 0) {
                    foundMember.setPreferredLocation(modifyInfo.getPreferredLocation());
                }
                if (modifyInfo.getPreferredType().length() > 0) {
                    foundMember.setPreferredType(modifyInfo.getPreferredType());
                }
                break;

            case "deactivate":

                RestTemplate rt = new RestTemplate();

                if (foundMember.getSocialLogin().equals("KAKAO")) {

                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Authorization", "Bearer" + foundMember.getAccessToken());

                    HttpEntity<MultiValueMap<String, String>> kakaoDeactivateRequest =
                            new HttpEntity<>(headers);

                    ResponseEntity<String> kakaoDeactivateResponse = rt.exchange(
                            "https://kapi.kakao.com/v1/user/unlink",
                            HttpMethod.POST,
                            kakaoDeactivateRequest,
                            String.class
                    );

                    String kakaoDeactivateResult = "";

                    try {
                        kakaoDeactivateResult = objectMapper.readValue(
                                kakaoDeactivateResponse.getBody(),
                                String.class);

                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }

                    foundMember.setIsDeleted("Y");
                    break;
                }

        }

    }

    public MemberDTO getAuthedMember(String header) throws JsonProcessingException {

        Map<String, String> headerMap = objectMapper.readValue(header, Map.class);

        String id = String.valueOf(headerMap.get("memberId"));

        Long memberNum = Long.parseLong(id);

        MemberEntity authedMember = memberRepository.findById(memberNum).get();

        return modelMapper.map(authedMember, MemberDTO.class);

    }

//    public MemberDTO findMemberByNum(long memberNum) {
//
//        MemberEntity member = memberRepository.findByNum(memberNum).get();
//
//        return modelMapper.map(member, MemberDTO.class);
//    }
}
**/

