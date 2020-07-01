package com.RealLis.specimenInhos.domain.PostBack.packagePID;

public class PID5 {
    /*患者姓名*/
    private String PID5_1="";
    /*患者拼音名*/
    private String PID5_2="";
    /*患者年龄*/
    private String PID5_3="";
    /*身高*/
    private String PID5_4="";
    /*体重*/
    private String PID5_5="";

    public String getPID5_1() {
        return PID5_1;
    }

    public void setPID5_1(String PID5_1) {
        this.PID5_1 = PID5_1;
    }

    public String getPID5_2() {
        return PID5_2;
    }

    public void setPID5_2(String PID5_2) {
        this.PID5_2 = PID5_2;
    }

    public String getPID5_3() {
        return PID5_3;
    }

    public void setPID5_3(String PID5_3) {
        this.PID5_3 = PID5_3;
    }

    public String getPID5_4() {
        return PID5_4;
    }

    public void setPID5_4(String PID5_4) {
        this.PID5_4 = PID5_4;
    }

    public String getPID5_5() {
        return PID5_5;
    }

    public void setPID5_5(String PID5_5) {
        this.PID5_5 = PID5_5;
    }

    public PID5() {
    }

    public PID5(String PID5_1, String PID5_2, String PID5_3, String PID5_4, String PID5_5) {
        this.PID5_1 = PID5_1;
        this.PID5_2 = PID5_2;
        this.PID5_3 = PID5_3;
        this.PID5_4 = PID5_4;
        this.PID5_5 = PID5_5;
    }

    @Override
    public String toString() {
        return
                 PID5_1 + '^' +
                 PID5_2 + '^' +
                 PID5_3 + '^' +
                 PID5_4 + '^' +
                 PID5_5 ;
    }
}
