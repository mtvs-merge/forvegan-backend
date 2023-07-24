package com.ohgiraffers.forepeproject.report.command.application.service;

import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.forepeproject.report.command.domain.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReportWriteService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportWriteService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Transactional
    public void writeReport(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        reportRepository.flush();
    }
}
