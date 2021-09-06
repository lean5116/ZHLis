package com.RealLis.specimenInhos.domain.PostBack;

import java.util.Date;

public class PostList {
    private Long jlxh;
    private String eventName;
    private String eventData;
    private Long micType;
    private Long repeat;
    private String patientId;
    private String visitNo;
    private String orderId;
    private String reportId;
    private String operdocId;
    private String operdocName;
    private Date operTime;

    public PostList(Long jlxh, String eventName, String eventData, Long micType, Long repeat, String patientId, String visitNo, String orderId, String reportId, String operdocId, String operdocName, Date operTime) {
        this.jlxh = jlxh;
        this.eventName = eventName;
        this.eventData = eventData;
        this.micType = micType;
        this.repeat = repeat;
        this.patientId = patientId;
        this.visitNo = visitNo;
        this.orderId = orderId;
        this.reportId = reportId;
        this.operdocId = operdocId;
        this.operdocName = operdocName;
        this.operTime = operTime;
    }

    public PostList() {
    }

    public Long getJlxh() {
        return jlxh;
    }

    public void setJlxh(Long jlxh) {
        this.jlxh = jlxh;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    public Long getMicType() {
        return micType;
    }

    public void setMicType(Long micType) {
        this.micType = micType;
    }

    public Long getRepeat() {
        return repeat;
    }

    public void setRepeat(Long repeat) {
        this.repeat = repeat;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(String visitNo) {
        this.visitNo = visitNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getOperdocId() {
        return operdocId;
    }

    public void setOperdocId(String operdocId) {
        this.operdocId = operdocId;
    }

    public String getOperdocName() {
        return operdocName;
    }

    public void setOperdocName(String operdocName) {
        this.operdocName = operdocName;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    @Override
    public String toString() {
        return "PostList{" +
                "jlxh=" + jlxh +
                ", eventName='" + eventName + '\'' +
                ", eventData='" + eventData + '\'' +
                ", micType=" + micType +
                ", repeat=" + repeat +
                ", patientId='" + patientId + '\'' +
                ", visitNo='" + visitNo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", reportId='" + reportId + '\'' +
                ", operdocId='" + operdocId + '\'' +
                ", operdocName='" + operdocName + '\'' +
                ", operTime=" + operTime +
                '}';
    }
}
