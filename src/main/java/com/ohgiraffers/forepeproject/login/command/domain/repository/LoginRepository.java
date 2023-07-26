package com.ohgiraffers.forepeproject.login.command.domain.repository;

import com.ohgiraffers.forepeproject.member.command.application.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.stereotype.Repository;

public interface LoginRepository extends JpaRepository<MemberEntity, Long> {

}
