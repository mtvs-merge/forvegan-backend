package com.ohgiraffers.forepeproject.report.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Entity(name = "Report")
@Table(name = "REPORT")
public class ReportEntity {
    @SequenceGenerator(
            name = "REPORT_SEQ_GENERATOR",
            sequenceName = "SEQ_REPORT_NUM",
            initialValue = 1,
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "REPORT_SEQ_GENERATOR"
    )
    @Column(name = "REPORT_NUM")
    private int reportNum;
    @Column(name = "REPORT_DATE")
    private String reportDate;
    @Column(name = "REPORT_COMMENT_NUM")
    private int reportCommentNum;
    @Column(name = "REPORT_POST_NUM")
    private int reportPostNum;
    @Column(name = "REPORTER")
    private String reporter;
    @Column(name = "REPORTEE")
    private String reportee;
    @Column(name ="REPORT_REASON")
    private String reportReason;

    @Column(name = "REPORT_SHOW_STATE")
    private String reportShowState;

    @PrePersist
    public void onPrePersist() { this.reportDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));}
}
