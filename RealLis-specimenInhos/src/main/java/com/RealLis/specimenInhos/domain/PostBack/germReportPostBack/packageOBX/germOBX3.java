package com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.packageOBX;

public class germOBX3 {
    /*检测项目ID*/
    private String OBX3_1="";
    /*系统名称*/
    private String OBX3_2="";
    /*细菌编码*/
    private String OBX3_3="";

    public germOBX3(String OBX3_1, String OBX3_2, String OBX3_3) {
        this.OBX3_1 = OBX3_1;
        this.OBX3_2 = OBX3_2;
        this.OBX3_3 = OBX3_3;
    }

    public germOBX3() {
    }

    public String getOBX3_1() {
        return OBX3_1;
    }

    public void setOBX3_1(String OBX3_1) {
        this.OBX3_1 = OBX3_1;
    }

    public String getOBX3_2() {
        return OBX3_2;
    }

    public void setOBX3_2(String OBX3_2) {
        this.OBX3_2 = OBX3_2;
    }

    public String getOBX3_3() {
        return OBX3_3;
    }

    public void setOBX3_3(String OBX3_3) {
        this.OBX3_3 = OBX3_3;
    }

    @Override
    public String toString() {
        return OBX3_1 + '^' +
               OBX3_2 + '^' +
               OBX3_3 ;
    }
}
