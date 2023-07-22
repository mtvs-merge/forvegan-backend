package com.ohgiraffers.forepeproject.member.query.domain.repository;


import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    @Query("SELECT m FROM Member AS m WHERE m.socialLogin LIKE :socialLogin AND m.socialId LIKE :socialId")
    MemberEntity findBySocialId(String socialLogin, String socialId);


//    List<Object> findByNum(long memberNum);
}
