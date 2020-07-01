package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR4 {
    /*检验项目ID*/
    private String OBR4_1="";
    /*检查项目名称*/
    private String OBR4_2="";
    /*检查子项类型*/
    private String OBR4_3="";
    /*检查类型*/
    private String OBR4_4="";

    public OBR4() {
    }

    public OBR4(String OBR4_1, String OBR4_2, String OBR4_3, String OBR4_4) {
        this.OBR4_1 = OBR4_1;
        this.OBR4_2 = OBR4_2;
        this.OBR4_3 = OBR4_3;
        this.OBR4_4 = OBR4_4;
    }

    public String getOBR4_1() {
        return OBR4_1;
    }

    public void setOBR4_1(String OBR4_1) {
        this.OBR4_1 = OBR4_1;
    }

    public String getOBR4_2() {
        return OBR4_2;
    }

    public void setOBR4_2(String OBR4_2) {
        this.OBR4_2 = OBR4_2;
    }

    public String getOBR4_3() {
        return OBR4_3;
    }

    public void setOBR4_3(String OBR4_3) {
        this.OBR4_3 = OBR4_3;
    }

    public String getOBR4_4() {
        return OBR4_4;
    }

    public void setOBR4_4(String OBR4_4) {
        this.OBR4_4 = OBR4_4;
    }

    @Override
    public String toString() {
        return  OBR4_1 + '^' +
                OBR4_2 + '^' +
                OBR4_3 + '^' +
                OBR4_4 ;
    }
}
