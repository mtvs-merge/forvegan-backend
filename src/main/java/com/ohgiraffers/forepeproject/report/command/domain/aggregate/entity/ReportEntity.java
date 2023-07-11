package com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportEntity {

    private int reportNum;
    private int reportDate;
    private int reportCommentNum;
    private int reportPostNum;
    private String reporter;
    private String reportee;
    private String reportReason;
}
