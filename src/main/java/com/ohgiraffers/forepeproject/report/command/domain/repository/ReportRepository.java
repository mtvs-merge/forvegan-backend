package com.ohgiraffers.forepeproject.report.command.domain.repository;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {
    ReportEntity findByPostNum(int postNum);
}