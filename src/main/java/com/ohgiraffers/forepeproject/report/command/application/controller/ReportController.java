package com.ohgiraffers.forepeproject.report.command.application.controller;

import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.application.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/report/*")
public class ReportController {
    private final ReportService reportService;
    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    @PostMapping("hi")
    public String saveReport(Model model, HttpServletRequest request) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setReportNum(Integer.parseInt(request.getParameter("reportid_no")));
        reportDTO.setReportDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        reportDTO.setReportCommentNum(Integer.parseInt(request.getParameter("ReportComment_no")));
        reportDTO.setReportPostNum(Integer.parseInt(request.getParameter("PostNum_no")));
        reportDTO.setReporter(request.getParameter("reporter"));
        reportDTO.setReportee(request.getParameter("reportee"));
        reportDTO.setReportReason(request.getParameter("reportReason"));
        reportService.saveReport(reportDTO);
        int message = reportDTO.getReportNum();
        String reporter = reportDTO.getReporter();
        model.addAttribute("message",message);
        model.addAttribute("reporter",reporter);

        return "report/hello";
    }

    @GetMapping("view")
    public ModelAndView list(ModelAndView model){
        List<ReportDTO> reportDTOList = reportService.viewreport();
        System.out.println(reportDTOList);
        model.addObject("boardList",reportDTOList);
        model.setViewName("report/list");
        return model;
    }

    @PostMapping("delete")
    public String removeReport(Model model, @RequestParam int review_no) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setReportNum(review_no);
        reportService.deletereportId(reportDTO.getReportNum());
        reportDTO.setReportReason("ewfkef");
        String deletea = reportDTO.getReportReason();
        model.addAttribute("deletea", deletea);
        return "report/delete";
    }
    }
