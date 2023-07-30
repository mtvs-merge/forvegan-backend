package com.ohgiraffers.forepeproject.member.query.domain.repository;

import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    MemberEntity findMemberByNum(int memberNum);
}
