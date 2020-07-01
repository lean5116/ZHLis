package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR15 {
    /*标本采集时间*/
    private String OBR15_1="";
    /*标本*/
    private String OBR15_2="";

    public OBR15(String OBR15_1, String OBR15_2) {
        this.OBR15_1 = OBR15_1;
        this.OBR15_2 = OBR15_2;
    }

    public OBR15() {
    }

    public String getOBR15_1() {
        return OBR15_1;
    }

    public void setOBR15_1(String OBR15_1) {
        this.OBR15_1 = OBR15_1;
    }

    public String getOBR15_2() {
        return OBR15_2;
    }

    public void setOBR15_2(String OBR15_2) {
        this.OBR15_2 = OBR15_2;
    }

    @Override
    public String toString() {
        return  OBR15_1 + '^' +
                OBR15_2 ;
    }
}
