package com.RealLis.specimenInhos.domain.PostBack.packagePV1;

public class PV1_3 {
    /*患者所属科室*/
    private String PV1_3_1="";
    /*患者所属病区*/
    private String PV1_3_2="";
    /*患者床号*/
    private String PV1_3_3="";
    /*患者所属科室代码*/
    private String PV1_3_4="";
    /*患者所属病区代码*/
    private String PV1_3_5="";
    /*接触隔离标志（艾滋等）0：非接触隔离；1接触隔离 ；无则未知*/
    private String PV1_3_6="";
    /*患者所在病房号*/
    private String PV1_3_7="";
    /*患者床标号*/
    private String PV1_3_8="";

    public PV1_3(String PV1_3_1, String PV1_3_2, String PV1_3_3, String PV1_3_4, String PV1_3_5, String PV1_3_6, String PV1_3_7, String PV1_3_8) {
        this.PV1_3_1 = PV1_3_1;
        this.PV1_3_2 = PV1_3_2;
        this.PV1_3_3 = PV1_3_3;
        this.PV1_3_4 = PV1_3_4;
        this.PV1_3_5 = PV1_3_5;
        this.PV1_3_6 = PV1_3_6;
        this.PV1_3_7 = PV1_3_7;
        this.PV1_3_8 = PV1_3_8;
    }

    public PV1_3() {
    }

    public String getPV1_3_1() {
        return PV1_3_1;
    }

    public void setPV1_3_1(String PV1_3_1) {
        this.PV1_3_1 = PV1_3_1;
    }

    public String getPV1_3_2() {
        return PV1_3_2;
    }

    public void setPV1_3_2(String PV1_3_2) {
        this.PV1_3_2 = PV1_3_2;
    }

    public String getPV1_3_3() {
        return PV1_3_3;
    }

    public void setPV1_3_3(String PV1_3_3) {
        this.PV1_3_3 = PV1_3_3;
    }

    public String getPV1_3_4() {
        return PV1_3_4;
    }

    public void setPV1_3_4(String PV1_3_4) {
        this.PV1_3_4 = PV1_3_4;
    }

    public String getPV1_3_5() {
        return PV1_3_5;
    }

    public void setPV1_3_5(String PV1_3_5) {
        this.PV1_3_5 = PV1_3_5;
    }

    public String getPV1_3_6() {
        return PV1_3_6;
    }

    public void setPV1_3_6(String PV1_3_6) {
        this.PV1_3_6 = PV1_3_6;
    }

    public String getPV1_3_7() {
        return PV1_3_7;
    }

    public void setPV1_3_7(String PV1_3_7) {
        this.PV1_3_7 = PV1_3_7;
    }

    public String getPV1_3_8() {
        return PV1_3_8;
    }

    public void setPV1_3_8(String PV1_3_8) {
        this.PV1_3_8 = PV1_3_8;
    }

    @Override
    public String toString() {
        return  PV1_3_1 + '^' +
                PV1_3_2 + '^' +
                PV1_3_3 + '^' +
                PV1_3_4 + '^' +
                PV1_3_5 + '^' +
                PV1_3_6 + '^' +
                PV1_3_7 + '^' +
                PV1_3_8 ;
    }
}
