package com.ohgiraffers.forepeproject.login.command.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity.MemberEntity;

public interface LoginRepository extends JpaRepository<MemberEntity, Long> {

}
