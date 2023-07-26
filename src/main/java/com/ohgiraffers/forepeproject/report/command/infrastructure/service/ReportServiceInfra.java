package com.ohgiraffers.forepeproject.report.command.infrastructure.service;

import com.ohgiraffers.forepeproject.report.command.application.dto.ReportDTO;
import com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.forepeproject.report.command.domain.repository.ReportRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ReportServiceInfra {

        private final ReportRepository reportRepository;


    public ReportServiceInfra(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

        @Override
        @Transactional
        public void releaseBlackList(ReportDTO reportdto) {
            try {
                ReportEntity reportEntity = reportRepository.findAllById(reportdto.getReporter());

                reportEntity.setReportNum(3);

                reportRepository.save(reportEntity);
                reportRepository.flush();

                //member.setBlackListStatus = false;

            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }



}
