package com.ohgiraffers.forepeproject.report.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@RequiredArgsConstructor   // Bean 주입 : @Autowired 대신에 생성자로!
@ToString
public class ReportDTO {
    private int reportNum;
    private String reportDate;
    private int reportCommentNum;
    private int reportPostNum;
    private String reporter;
    private String reportee;
    private String reportReason;
}