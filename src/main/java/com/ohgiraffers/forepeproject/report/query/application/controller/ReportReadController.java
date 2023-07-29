package com.ohgiraffers.forepeproject.report.query.application.controller;

import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.application.service.ReportService;
import com.ohgiraffers.forepeproject.report.query.application.service.ReportReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportReadController {

    private final ReportReadService reportReadService;

    @Autowired
    public ReportReadController(ReportReadService reportReadService) {
        this.reportReadService = reportReadService;
    }

    @PostMapping("")
    public String getAllReportsPagination(@RequestParam int page, Model model) {
        List<ReportDTO> requestList = reportReadService.getAllReports(page);

        model.addAttribute(requestList);

        return "/report/list";

    }

    @GetMapping("/getDetails")
    public String getReportDetails(@RequestParam Integer reportNum, Model model) {
        model.addAttribute(reportReadService.getReportDetails(reportNum));

        return "/report/details";
    }


}
