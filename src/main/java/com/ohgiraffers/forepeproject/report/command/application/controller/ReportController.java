package com.ohgiraffers.forepeproject.report.command.application.controller;


import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.application.service.ReportService;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/write")
    public String writeReport(@RequestParam ReportDTO reportDTO) {
        ReportEntity reportEntity = new ReportEntity();
        BeanUtils.copyProperties(reportDTO, reportEntity);

        reportService.writeReport(reportEntity);

        return "redirect:/report";
    }

    @PostMapping("/delete")
    public String deleteReport(@RequestParam ReportEntity reportEntity, RedirectAttributes redirectAttributes) {
        if(reportService.ownerVerification(reportEntity)){
            reportService.deleteReport(reportEntity.getReportNum());
        } else {
            redirectAttributes.addFlashAttribute("message", "신고 작성자가 아닙니다");
        }

        return "redirect:/report";
    }

    @PostMapping("/update")
    public String updateReport(@RequestParam ReportEntity reportEntity, RedirectAttributes redirectAttributes) {

        if(reportService.ownerVerification(reportEntity)) {
          reportService.updateReport(reportEntity);
        } else {
            redirectAttributes.addFlashAttribute("message", "신고 작성자가 아닙니다");
        }

        return "redirect:/report";
    }



}
