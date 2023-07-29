package com.ohgiraffers.forepeproject.report.command.application.service;


import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReportCreateTesting {

    @Autowired
    private ReportService reportService;

    @DisplayName("report create test")
    @ParameterizedTest
    void testCreateReport() {
        ReportEntity reportEntity = new ReportEntity();

        reportEntity.setReportPostNum(1);
        reportEntity.setReporter("me");
        reportEntity.setReportee("you");

        reportService.writeReport(reportEntity);
    }



}
