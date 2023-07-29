package com.ohgiraffers.forepeproject.report.query.infrastructure.repository;

import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    List<ReportDTO> findAllReports(int Page);
    ReportDTO findReportDetails(int reportNum);

}
