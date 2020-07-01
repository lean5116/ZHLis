package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR35 {
    /*报告者ID*/
    private String OBR35_1="";
    /*报告者姓名*/
    private String OBR35_2="";
    /*报告者手机号*/
    private String OBR35_3="";

    public OBR35(String OBR35_1, String OBR35_2, String OBR35_3) {
        this.OBR35_1 = OBR35_1;
        this.OBR35_2 = OBR35_2;
        this.OBR35_3 = OBR35_3;
    }

    public OBR35() {
    }

    public String getOBR35_1() {
        return OBR35_1;
    }

    public void setOBR35_1(String OBR35_1) {
        this.OBR35_1 = OBR35_1;
    }

    public String getOBR35_2() {
        return OBR35_2;
    }

    public void setOBR35_2(String OBR35_2) {
        this.OBR35_2 = OBR35_2;
    }

    public String getOBR35_3() {
        return OBR35_3;
    }

    public void setOBR35_3(String OBR35_3) {
        this.OBR35_3 = OBR35_3;
    }

    @Override
    public String toString() {
        return  OBR35_1 + '^' +
                OBR35_2 +'^'+
                OBR35_3 ;
    }
}
