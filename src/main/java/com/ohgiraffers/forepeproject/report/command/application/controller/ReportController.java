package com.ohgiraffers.forepeproject.report.command.application.controller;

import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.application.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;
    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/hi")
    public void saveReport(HttpServletRequest request) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setReportCommentNum(Integer.parseInt(request.getParameter("review_no")));
        reportDTO.setReportNum(Integer.parseInt(request.getParameter("report_type")));
        reportDTO.setReporter(request.getParameter("report_member_no"));
        reportDTO.setReportee(request.getParameter("reporter_no"));
        reportDTO.setReportReason(request.getParameter("reportee_no"));
        reportDTO.setReportReason(request.getParameter("reportReason_no"));


    }


}
