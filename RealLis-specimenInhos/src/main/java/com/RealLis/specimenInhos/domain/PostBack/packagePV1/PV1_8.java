package com.RealLis.specimenInhos.domain.PostBack.packagePV1;

public class PV1_8 {
    /*转诊医生ID*/
    private String PV1_8_1="";
    /*转诊医生姓名*/
    private String PV1_8_2="";

    public PV1_8(String PV1_8_1, String PV1_8_2) {
        this.PV1_8_1 = PV1_8_1;
        this.PV1_8_2 = PV1_8_2;
    }

    public PV1_8() {
    }

    public String getPV1_8_1() {
        return PV1_8_1;
    }

    public void setPV1_8_1(String PV1_8_1) {
        this.PV1_8_1 = PV1_8_1;
    }

    public String getPV1_8_2() {
        return PV1_8_2;
    }

    public void setPV1_8_2(String PV1_8_2) {
        this.PV1_8_2 = PV1_8_2;
    }

    @Override
    public String toString() {
        return PV1_8_1 + '^' +
               PV1_8_2 ;
    }
}
