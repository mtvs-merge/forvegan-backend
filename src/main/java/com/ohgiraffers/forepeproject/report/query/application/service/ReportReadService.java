package com.ohgiraffers.forepeproject.report.query.application.service;

import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.domain.repository.ReportRepository;
import com.ohgiraffers.forepeproject.report.query.infrastructure.repository.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportReadService {

    private final ReportMapper reportMapper;

    @Autowired
    ReportReadService(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    public List<ReportDTO> getAllReports(int page) {
        return reportMapper.findAllReports(page);
    }

    public ReportDTO getReportDetails(int reportNum) {

        return reportMapper.findReportDetails(reportNum);
    }
}
