package com.ohgiraffers.forepeproject.report.command.application.service;

import com.ohgiraffers.forepeproject.report.query.application.service.ReportReadService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReportReadAllTesting {

    @Autowired
    private ReportReadService reportReadService;

    @DisplayName("read all report test")
    @ParameterizedTest
    void testReadAllReport() {

        System.out.println(reportReadService.getAllReports(0).get(0).getReportReason());
    }
}
