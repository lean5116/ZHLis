package com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.packageZMIC;

public class ZMIC3 {
    private String ZMIC3_1="";
    private String ZMIC3_2="";

    public ZMIC3(String ZMIC3_1, String ZMIC3_2) {
        this.ZMIC3_1 = ZMIC3_1;
        this.ZMIC3_2 = ZMIC3_2;
    }

    public ZMIC3() {
    }

    public String getZMIC3_1() {
        return ZMIC3_1;
    }

    public void setZMIC3_1(String ZMIC3_1) {
        this.ZMIC3_1 = ZMIC3_1;
    }

    public String getZMIC3_2() {
        return ZMIC3_2;
    }

    public void setZMIC3_2(String ZMIC3_2) {
        this.ZMIC3_2 = ZMIC3_2;
    }

    @Override
    public String toString() {
        return ZMIC3_1 + '^' +
               ZMIC3_2 ;
    }
}
