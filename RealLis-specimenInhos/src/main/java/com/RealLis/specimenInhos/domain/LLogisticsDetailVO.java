package com.RealLis.specimenInhos.domain;

public class LLogisticsDetailVO {
    private String wlbh;
    private String tmh;
    private String bedNum;
    private String patientName;
    private String examinaim;

    public LLogisticsDetailVO(String wlbh, String tmh, String bedNum, String patientName, String examinaim) {
        this.wlbh = wlbh;
        this.tmh = tmh;
        this.bedNum = bedNum;
        this.patientName = patientName;
        this.examinaim = examinaim;
    }

    public LLogisticsDetailVO() {
    }

    public String getWlbh() {
        return wlbh;
    }

    public void setWlbh(String wlbh) {
        this.wlbh = wlbh;
    }

    public String getTmh() {
        return tmh;
    }

    public void setTmh(String tmh) {
        this.tmh = tmh;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getExaminaim() {
        return examinaim;
    }

    public void setExaminaim(String examinaim) {
        this.examinaim = examinaim;
    }
}
