package com.RealLis.specimenInhos.domain.ReturnAudit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class auditBody {
    private Long jlxh;

    private String patientID;

    private String visitNo;

    private String orderId;

    private String reportId;

    private String operDocId;

    private String operDocName;

    private Date operTime;

    public void setPatientID(String patientID){
        this.patientID = patientID;
    }
    public String getPatientID(){
        return this.patientID;
    }
    public void setVisitNo(String visitNo){
        this.visitNo = visitNo;
    }
    public String getVisitNo(){
        return this.visitNo;
    }
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }
    public String getOrderId(){
        return this.orderId;
    }
    public void setReportId(String reportId){
        this.reportId = reportId;
    }
    public String getReportId(){
        return this.reportId;
    }
    public void setOperDocId(String operDocId){
        this.operDocId = operDocId;
    }
    public String getOperDocId(){
        return this.operDocId;
    }
    public void setOperDocName(String operDocName){
        this.operDocName = operDocName;
    }
    public String getOperDocName(){
        return this.operDocName;
    }
    public void setOperTime(Date operTime){
        this.operTime = operTime;
    }
    public Date getOperTime(){
        return this.operTime;
    }

    public Long getJlxh() {
        return jlxh;
    }

    public void setJlxh(Long jlxh) {
        this.jlxh = jlxh;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "\"Body\":{" +
                "\"patientID\":\"" + patientID + '\"' +
                ", \"visitNo\":\"" + visitNo + '\"' +
                ", \"orderId\":[\"" + orderId + "\"]" +
                ", \"reportId\":\"" + reportId + '\"' +
                ", \"operDocId\":\"" + operDocId + '\"' +
                ", \"operDocName\":\"" + operDocName + '\"' +
                ", \"operTime\":\"" + formatter.format(operTime) + '\"' +
                '}';
    }
}
