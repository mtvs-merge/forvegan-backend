package com.ohgiraffers.forepeproject.member.query.domain.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Member;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query(value = "SELECT MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PWD, MEMBER_NICKNAME, BLACKLIST, REPORT_COUNT, JOIN_DATE, LEVEL_UP_POINT " +
            "FROM MEMBER " +
            "ORDER BY MEMBER_NUM ASC",
            nativeQuery = true)
    List<Member> findAllMember();

    @Query(value = "SELECT MEMBER_NUM, MEMBER_NAME, MEMBER_ID, MEMBER_PWD, MEMBER_NICKNAME, BLACKLIST, REPORT_COUNT, JOIN_DATE, LEVEL_UP_POINT " +
            "FROM MEMBER " +
            "WHERE MEMBER_NUM LIKE :memberNum" +
            "ORDER BY MEMBER_NUM DESC",
            nativeQuery = true)
    List<Member> findByMember(@Param("memberNum")int memberNum);
}
