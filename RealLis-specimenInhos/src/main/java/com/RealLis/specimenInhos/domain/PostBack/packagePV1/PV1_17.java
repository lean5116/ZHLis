package com.RealLis.specimenInhos.domain.PostBack.packagePV1;

public class PV1_17 {
    /*接诊医生ID*/
    private String PV1_17_1="";
    /*接诊医生姓名*/
    private String PV1_18_2="";

    public PV1_17(String PV1_17_1, String PV1_18_2) {
        this.PV1_17_1 = PV1_17_1;
        this.PV1_18_2 = PV1_18_2;
    }

    public PV1_17() {
    }

    public String getPV1_17_1() {
        return PV1_17_1;
    }

    public void setPV1_17_1(String PV1_17_1) {
        this.PV1_17_1 = PV1_17_1;
    }

    public String getPV1_18_2() {
        return PV1_18_2;
    }

    public void setPV1_18_2(String PV1_18_2) {
        this.PV1_18_2 = PV1_18_2;
    }

    @Override
    public String toString() {
        return  PV1_17_1 + '^' +
                PV1_18_2 ;
    }
}
