package com.ohgiraffers.forepeproject.report.command.application.service;

import com.ohgiraffers.forepeproject.report.query.application.service.ReportReadService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReportReadTesting {

    @Autowired
    private ReportReadService reportReadService;

    @DisplayName("report read test")
    @ParameterizedTest
    void testReadReport() {
        System.out.println(reportReadService.getReportDetails(1).getReportReason());
    }
}
