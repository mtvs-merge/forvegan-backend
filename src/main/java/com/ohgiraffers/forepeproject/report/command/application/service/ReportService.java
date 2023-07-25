package com.ohgiraffers.forepeproject.report.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.forepeproject.report.command.domain.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Transactional
    public void deletePost(ReportDTO reportdto) {

        ReportEntity reportEntity = reportRepository.findByPostNum(reportdto.getReportNum());

        reportEntity.setReportNum(3);

        reportRepository.save(reportEntity);
        reportRepository.flush();

    }
}
