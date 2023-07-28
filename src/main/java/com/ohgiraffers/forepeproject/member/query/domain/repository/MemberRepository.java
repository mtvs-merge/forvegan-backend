package com.ohgiraffers.forepeproject.member.query.domain.repository;

/*
import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByMemberNickname(String memberNickname);

    List<MemberEntity> findByMemberNickName(@Param("memberNickname")String memberNickname, @Param("joinDate")String joinDate);

    @Query("SELECT m FROM Member AS m WHERE m.socialLogin LIKE :socialLogin AND m.socialId = :socialId")
    MemberEntity findBySocialId(String socialLogin, long socialId);
}
*/