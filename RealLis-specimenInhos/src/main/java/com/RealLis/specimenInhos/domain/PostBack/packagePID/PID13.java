package com.RealLis.specimenInhos.domain.PostBack.packagePID;


public class PID13 {
    /*手机号码*/
    private String PID13_1="";
    /*家庭电话号码*/
    private String PID13_2="";

    public String getPID13_1() {
        return PID13_1;
    }

    public void setPID13_1(String PID13_1) {
        this.PID13_1 = PID13_1;
    }

    public String getPID13_2() {
        return PID13_2;
    }

    public void setPID13_2(String PID13_2) {
        this.PID13_2 = PID13_2;
    }

    public PID13(String PID13_1, String PID13_2) {
        this.PID13_1 = PID13_1;
        this.PID13_2 = PID13_2;
    }

    public PID13() {
    }

    @Override
    public String toString() {
        return  PID13_1 + '^' +
                PID13_2 ;
    }
}
