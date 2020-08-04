package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR33 {
    /*审核者ID*/
    private String OBR33_1="";
    /*审核者姓名*/
    private String OBR33_2="";

    public OBR33(String OBR33_1, String OBR33_2) {
        this.OBR33_1 = OBR33_1;
        this.OBR33_2 = OBR33_2;
    }

    public OBR33() {
    }

    public String getOBR33_1() {
        return OBR33_1;
    }

    public void setOBR33_1(String OBR33_1) {
        this.OBR33_1 = OBR33_1;
    }

    public String getOBR33_2() {
        return OBR33_2;
    }

    public void setOBR33_2(String OBR33_2) {
        this.OBR33_2 = OBR33_2;
    }

    @Override
    public String toString() {
        return  OBR33_1 + '&' +
                OBR33_2 ;
    }
}
