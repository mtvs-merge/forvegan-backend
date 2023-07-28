package com.ohgiraffers.forepeproject.report.command.application.service;

import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.forepeproject.report.command.domain.repository.ReportRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public ReportService(ReportRepository reportRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.reportRepository = reportRepository;
    }


    @Transactional
    public void saveReport(ReportDTO reportdto) {

        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setReportNum(reportdto.getReportNum());
        reportEntity.setReportDate(reportdto.getReportDate());
        reportEntity.setReportNum(reportdto.getReportCommentNum());
        reportEntity.setReportPostNum(reportdto.getReportPostNum());
        reportEntity.setReporter(reportdto.getReporter());
        reportEntity.setReportee(reportdto.getReportee());
        reportEntity.setReportReason(reportdto.getReportReason());
        reportRepository.save(reportEntity);
        reportRepository.flush();

    }
    @Transactional
    public List<ReportDTO> viewreport() {

        List<ReportEntity> reportlist = reportRepository.findAll();

        return reportlist.stream().map(reportNum -> modelMapper.map(reportNum, ReportDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public void deletereportId(int reportNo) {

        try {

            ReportEntity report = reportRepository.findById(reportNo)
                    .orElseThrow(() -> new NotFoundException("존재하지 않은 넘버입니다."));
            reportRepository.delete(report);

        }
        catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

    }



}
