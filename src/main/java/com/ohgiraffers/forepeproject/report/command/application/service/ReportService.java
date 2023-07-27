package com.ohgiraffers.forepeproject.report.command.application.service;

import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.forepeproject.report.command.domain.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Transactional
    public void writeReport(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        reportRepository.flush();
    }

    @Transactional
    public void updateReport(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        reportRepository.flush();
    }

    @Transactional
    public void deleteReport(Integer reportNum) {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setReportNum(reportNum);
        reportEntity.setReportShowState("N");
    }

    public boolean ownerVerification(ReportEntity reportEntity) {
        ReportEntity re = reportRepository.getReferenceById(reportEntity.getReportNum());

        if(re.getReporter() == reportEntity.getReporter()) {
            return true;
        } else {
            return false;
        }

    }
}
