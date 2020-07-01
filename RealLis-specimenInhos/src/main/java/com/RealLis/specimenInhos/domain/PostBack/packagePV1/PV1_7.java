package com.RealLis.specimenInhos.domain.PostBack.packagePV1;

public class PV1_7 {
    /*主治医生ID*/
    private String PV1_7_1="";
    /*主治医生姓名*/
    private String PV1_7_2="";

    public PV1_7(String PV1_7_1, String PV1_7_2) {
        this.PV1_7_1 = PV1_7_1;
        this.PV1_7_2 = PV1_7_2;
    }

    public PV1_7() {
    }

    public String getPV1_7_1() {
        return PV1_7_1;
    }

    public void setPV1_7_1(String PV1_7_1) {
        this.PV1_7_1 = PV1_7_1;
    }

    public String getPV1_7_2() {
        return PV1_7_2;
    }

    public void setPV1_7_2(String PV1_7_2) {
        this.PV1_7_2 = PV1_7_2;
    }

    @Override
    public String toString() {
        return  PV1_7_1 + '^' +
                PV1_7_2 ;
    }
}
