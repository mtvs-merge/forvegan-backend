package com.ohgiraffers.forepeproject.report.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.application.service.ReportWriteService;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report/write")
public class ReportWriteController {

    private final ReportWriteService reportWriteService;

    @Autowired
    public ReportWriteController(ReportWriteService reportWriteService) {
        this.reportWriteService = reportWriteService;
    }

    @PostMapping("/all")
    public String writeReport(@RequestParam ReportDTO reportDTO) {

        ReportEntity reportEntity = new ReportEntity();

        BeanUtils.copyProperties(reportDTO, reportEntity);

        reportWriteService.writeReport(reportEntity);


        return "/report";
    }

}
