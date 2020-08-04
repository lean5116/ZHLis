package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR32 {
    /*报告者ID*/
    private String OBR32_1="";
    /*报告者姓名*/
    private String OBR32_2="";

    public OBR32(String OBR32_1, String OBR32_2) {
        this.OBR32_1 = OBR32_1;
        this.OBR32_2 = OBR32_2;
    }

    public OBR32() {
    }

    public String getOBR32_1() {
        return OBR32_1;
    }

    public void setOBR32_1(String OBR32_1) {
        this.OBR32_1 = OBR32_1;
    }

    public String getOBR32_2() {
        return OBR32_2;
    }

    public void setOBR32_2(String OBR32_2) {
        this.OBR32_2 = OBR32_2;
    }

    @Override
    public String toString() {
        return  OBR32_1 + '&' +
                OBR32_2 ;
    }
}
