package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR15 {
    /*标本采集时间*/
    private String ORB15_1="";
    /*标本*/
    private String ORB15_2="";

    public OBR15(String ORB15_1, String ORB15_2) {
        this.ORB15_1 = ORB15_1;
        this.ORB15_2 = ORB15_2;
    }

    public OBR15() {
    }

    public String getORB15_1() {
        return ORB15_1;
    }

    public void setORB15_1(String ORB15_1) {
        this.ORB15_1 = ORB15_1;
    }

    public String getORB15_2() {
        return ORB15_2;
    }

    public void setORB15_2(String ORB15_2) {
        this.ORB15_2 = ORB15_2;
    }

    @Override
    public String toString() {
        return  ORB15_1 + '^' +
                ORB15_2 ;
    }
}
