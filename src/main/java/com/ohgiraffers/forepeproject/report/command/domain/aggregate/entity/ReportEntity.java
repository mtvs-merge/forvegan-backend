package com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@Setter
@ToString
@Entity(name = "Report")
@Table(name = "REPORT")
@SequenceGenerator(
        name = "REPORT_SEQ_GENERATOR",
        sequenceName = "SEQ_REPORT_NUM",
        initialValue = 1,
        allocationSize = 1
)
public class ReportEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "REPORT_SEQ_GENERATOR"
    )
    @Column(name = "REPORT_NUM",nullable = false)
    private int reportNum;
    @Column(name = "REPORT_DATE",length =45,nullable = false )
    private String reportDate;
    @Column(name = "REPORT_COMMENT_NUM")
    private int reportCommentNum;
    @Column(name = "REPORT_POST_NUM")
    private int reportPostNum;
    @Column(name = "REPORTER",nullable = false)
    private String reporter;
    @Column(name = "REPORTEE",length = 45,nullable = false)
    private String reportee;
    @Column(name ="REPORT_REASON",length = 45,nullable = false)
    private String reportReason;

    public ReportEntity(int reportNum, String reportDate, int reportCommentNum, int reportPostNum, String reporter, String reportee, String reportReason) {
        this.reportNum = reportNum;
        this.reportDate = reportDate;
        this.reportCommentNum = reportCommentNum;
        this.reportPostNum = reportPostNum;
        this.reporter = reporter;
        this.reportee = reportee;
        this.reportReason = reportReason;
    }

    @PrePersist
    public void onPrePersist() { this.reportDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));}
}
