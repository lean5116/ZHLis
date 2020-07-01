package com.RealLis.specimenInhos.domain.PostBack.packagePID;


public class PID11 {
    /*家庭地址*/
    private String PID11_1="";
    /*邮编*/
    private String PID11_2="";

    public String getPID11_1() {
        return PID11_1;
    }

    public void setPID11_1(String PID11_1) {
        this.PID11_1 = PID11_1;
    }

    public String getPID11_2() {
        return PID11_2;
    }

    public void setPID11_2(String PID11_2) {
        this.PID11_2 = PID11_2;
    }

    public PID11() {
    }

    public PID11(String PID11_1, String PID11_2) {
        this.PID11_1 = PID11_1;
        this.PID11_2 = PID11_2;
    }

    @Override
    public String toString() {
        return  PID11_1 + '^' +
                PID11_2 ;
    }
}
