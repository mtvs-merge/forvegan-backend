package com.ohgiraffers.forepeproject.report.command.application.dto;

public class ReportDTO {

    private int reportNum;

    private String reportDate;

    private int reportCommentNum;

    private int reportPostNum;

    private String reporter;

    private String reportee;

    private String reportReason;


    public ReportDTO(int reportNum, String reportDate, int reportCommentNum, int reportPostNum, String reporter, String reportee, String reportReason) {
        this.reportNum = reportNum;
        this.reportDate = reportDate;
        this.reportCommentNum = reportCommentNum;
        this.reportPostNum = reportPostNum;
        this.reporter = reporter;
        this.reportee = reportee;
        this.reportReason = reportReason;
    }

    public int getReportNum() {
        return reportNum;
    }

    public void setReportNum(int reportNum) {
        this.reportNum = reportNum;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public int getReportCommentNum() {
        return reportCommentNum;
    }

    public void setReportCommentNum(int reportCommentNum) {
        this.reportCommentNum = reportCommentNum;
    }

    public int getReportPostNum() {
        return reportPostNum;
    }

    public void setReportPostNum(int reportPostNum) {
        this.reportPostNum = reportPostNum;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReportee() {
        return reportee;
    }

    public void setReportee(String reportee) {
        this.reportee = reportee;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }
}
