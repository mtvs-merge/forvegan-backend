package com.ohgiraffers.forepeproject.report.command.application.service;

import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReportUpdateTesting {

    @Autowired
    private ReportService reportService;


    @DisplayName("report update test")
    @ParameterizedTest
    void testUpdateReport() {
        ReportEntity reportEntity = new ReportEntity();

        reportEntity.setReportNum(1);
        reportEntity.setReportReason("imabanana");

        reportService.updateReport(reportEntity);
    }

}
