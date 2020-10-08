package com.RealLis.specimenInhos.domain.PostBack.reportPostBack.packageOBX;

public class OBX3 {
    /*检查项目ID*/
    private String OBX3_1="";
    /*检查项目名称*/
    private String OBX3_2="";

    public OBX3(String OBX3_1, String OBX3_2) {
        this.OBX3_1 = OBX3_1;
        this.OBX3_2 = OBX3_2;
    }

    public OBX3() {
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

    @Override
    public String toString() {
        return  OBX3_1 + '^' +
                OBX3_2 ;
    }
}
