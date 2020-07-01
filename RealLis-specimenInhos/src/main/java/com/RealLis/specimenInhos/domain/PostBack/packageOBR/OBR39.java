package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR39 {
    /*报告备注*/
    private String OBR39_1="";
    /*解释信息*/
    private String OBR39_2="";

    public OBR39(String OBR39_1, String OBR39_2) {
        this.OBR39_1 = OBR39_1;
        this.OBR39_2 = OBR39_2;
    }

    public OBR39() {
    }

    public String getOBR39_1() {
        return OBR39_1;
    }

    public void setOBR39_1(String OBR39_1) {
        this.OBR39_1 = OBR39_1;
    }

    public String getOBR39_2() {
        return OBR39_2;
    }

    public void setOBR39_2(String OBR39_2) {
        this.OBR39_2 = OBR39_2;
    }

    @Override
    public String toString() {
        return  OBR39_1 + '^' +
                OBR39_2 ;
    }
}
