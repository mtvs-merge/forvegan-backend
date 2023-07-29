package com.ohgiraffers.forepeproject.member.query.domain.repository;

import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberMapper {

    MemberEntity findMemberByNum(int memberNum);
}
