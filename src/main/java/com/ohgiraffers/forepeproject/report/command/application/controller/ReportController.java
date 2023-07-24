package com.ohgiraffers.forepeproject.report.command.application.controller;

import com.ohgiraffers.forepeproject.report.command.domain.repository.ReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {
    private final ReportRepository reportRepository;


    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
}
