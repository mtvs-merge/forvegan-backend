package com.ohgiraffers.forepeproject.report.command.application.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

@SpringBootTest
public class ReportDeleteTesting {

    @Autowired
    private ReportService reportService;

    @DisplayName("report delete test")
    @ParameterizedTest
    void testDeleteReport() {

        reportService.deleteReport(1);

    }

}
