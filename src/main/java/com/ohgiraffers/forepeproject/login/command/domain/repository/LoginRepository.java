package com.ohgiraffers.forepeproject.login.command.domain.repository;

import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<MemberEntity, Long> {

}
