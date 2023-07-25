package com.ohgiraffers.forepeproject.report.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor   // Bean 주입 : @Autowired 대신에 생성자로!
@ToString
public class ReportNewDTO {
    private int reportCommentNum;
    private int reportPostNum;
    private String reporter;
    private String reportee;
    private String reportReason;
}
