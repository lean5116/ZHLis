package com.RealLis.specimenInhos.domain.PostBack.germReportPostBack;

import com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.packageZMIC.ZMIC3;

public class ZMIC {
    /*细菌ID*/
    private String ZMIC1 ="";
    /**/
    private String ZMIC2 ="";

    private String ZMIC_ID ="";
    /*药敏信息*/
    private ZMIC3 ZMIC3 =new ZMIC3();
    /*第N个药敏*/
    private String ZMIC4 ="";
    /*定量结果*/
    private String ZMIC5 ="";
    /*单位*/
    private String ZMIC6 ="";
    /*折点*/
    private String ZMIC7 ="";
    /*耐药性结果*/
    private String ZMIC8 ="";
    /*检验方法*/
    private String ZMIC9 ="";

    public ZMIC(String ZMIC1, String ZMIC2, com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.packageZMIC.ZMIC3 ZMIC3, String ZMIC4, String ZMIC5, String ZMIC6, String ZMIC7, String ZMIC8, String ZMIC9) {
        this.ZMIC1 = ZMIC1;
        this.ZMIC2 = ZMIC2;
        this.ZMIC3 = ZMIC3;
        this.ZMIC4 = ZMIC4;
        this.ZMIC5 = ZMIC5;
        this.ZMIC6 = ZMIC6;
        this.ZMIC7 = ZMIC7;
        this.ZMIC8 = ZMIC8;
        this.ZMIC9 = ZMIC9;
    }

    public ZMIC() {
    }

    public String getZMIC1() {
        return ZMIC1;
    }

    public void setZMIC1(String ZMIC1) {
        this.ZMIC1 = ZMIC1;
    }

    public String getZMIC2() {
        return ZMIC2;
    }

    public void setZMIC2(String ZMIC2) {
        this.ZMIC2 = ZMIC2;
    }

    public com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.packageZMIC.ZMIC3 getZMIC3() {
        return ZMIC3;
    }

    public void setZMIC3(com.RealLis.specimenInhos.domain.PostBack.germReportPostBack.packageZMIC.ZMIC3 ZMIC3) {
        this.ZMIC3 = ZMIC3;
    }

    public String getZMIC4() {
        return ZMIC4;
    }

    public void setZMIC4(String ZMIC4) {
        this.ZMIC4 = ZMIC4;
    }

    public String getZMIC5() {
        return ZMIC5;
    }

    public void setZMIC5(String ZMIC5) {
        this.ZMIC5 = ZMIC5;
    }

    public String getZMIC6() {
        return ZMIC6;
    }

    public void setZMIC6(String ZMIC6) {
        this.ZMIC6 = ZMIC6;
    }

    public String getZMIC7() {
        return ZMIC7;
    }

    public void setZMIC7(String ZMIC7) {
        this.ZMIC7 = ZMIC7;
    }

    public String getZMIC8() {
        return ZMIC8;
    }

    public void setZMIC8(String ZMIC8) {
        this.ZMIC8 = ZMIC8;
    }

    public String getZMIC9() {
        return ZMIC9;
    }

    public void setZMIC9(String ZMIC9) {
        this.ZMIC9 = ZMIC9;
    }

    public String getZMIC_ID() {
        return ZMIC_ID;
    }

    public void setZMIC_ID(String ZMIC_ID) {
        this.ZMIC_ID = ZMIC_ID;
    }

    @Override
    public String toString() {
        return "ZMIC|" +
                ZMIC1 + '|' +
                ZMIC2 + '|' +
                ZMIC3.toString() +'|'+
                ZMIC4 + '|' +
                ZMIC5 + '|' +
                ZMIC6 + '|' +
                ZMIC7 + '|' +
                ZMIC8 + '|' +
                ZMIC9 +'\n';
    }
}
