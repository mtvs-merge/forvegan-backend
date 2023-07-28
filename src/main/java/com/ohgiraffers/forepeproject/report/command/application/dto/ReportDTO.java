package com.ohgiraffers.forepeproject.report.command.application.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor   // Bean 주입 : @Autowired 대신에 생성자로!
@ToString
@AllArgsConstructor
public class ReportDTO {
    private int reportNum;
    private String reportDate;
    private int reportCommentNum;
    private int reportPostNum;
    private String reporter;
    private String reportee;
    private String reportReason;

    public ReportDTO(int reportNum, String reportDate, int reportCommentNum, int reportCommentNum1, int reportPostNum, String reporter, String reportee, String reportReason) {
    }
}
