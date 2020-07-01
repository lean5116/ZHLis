package com.RealLis.specimenInhos.domain.PostBack;

public class MSH {
    /*字段分隔符 默认 |*/
    private String MSH1="|";
    /*编码字符 默认 ^~\&*/
    private String MSH2="^~\\&";
    /*消息发起者 LIS*/
    private String MSH3="";
    /*发送院区*/
    private String MSH4="";
    /*接收消息者 HIS*/
    private String MSH5="";
    /*接收院区*/
    private String MSH6="";
    /*消息的日期/时间 格式 20200303094408+0800*/
    private String MSH7="";
    /*空字段*/
    private String MSH8="";
    /*消息类型 OUL^R21*/
    private String MSH9="";
    /*GUID*/
    private String MSH10="";
    /*处理编号 P*/
    private String MSH11="";
    /*版本号 2.4*/
    private String MSH12="";
    /*空字段*/
    private String MSH13="";
    /*空字段*/
    private String MSH14="";
    /*接收确认类型 NE*/
    private String MSH15="";
    /*申请确认类型 AL*/
    private String MSH16="";
    /*空字段*/
    private String MSH17="";
    /*字符集 utf-8*/
    private String MSH18="";

    public String getMSH1() {
        return MSH1;
    }

    public void setMSH1(String MSH1) {
        this.MSH1 = MSH1;
    }

    public String getMSH2() {
        return MSH2;
    }

    public void setMSH2(String MSH2) {
        this.MSH2 = MSH2;
    }

    public String getMSH3() {
        return MSH3;
    }

    public void setMSH3(String MSH3) {
        this.MSH3 = MSH3;
    }

    public String getMSH4() {
        return MSH4;
    }

    public void setMSH4(String MSH4) {
        this.MSH4 = MSH4;
    }

    public String getMSH5() {
        return MSH5;
    }

    public void setMSH5(String MSH5) {
        this.MSH5 = MSH5;
    }

    public String getMSH6() {
        return MSH6;
    }

    public void setMSH6(String MSH6) {
        this.MSH6 = MSH6;
    }

    public String getMSH7() {
        return MSH7;
    }

    public void setMSH7(String MSH7) {
        this.MSH7 = MSH7;
    }

    public String getMSH8() {
        return MSH8;
    }

    public void setMSH8(String MSH8) {
        this.MSH8 = MSH8;
    }

    public String getMSH9() {
        return MSH9;
    }

    public void setMSH9(String MSH9) {
        this.MSH9 = MSH9;
    }

    public String getMSH10() {
        return MSH10;
    }

    public void setMSH10(String MSH10) {
        this.MSH10 = MSH10;
    }

    public String getMSH11() {
        return MSH11;
    }

    public void setMSH11(String MSH11) {
        this.MSH11 = MSH11;
    }

    public String getMSH12() {
        return MSH12;
    }

    public void setMSH12(String MSH12) {
        this.MSH12 = MSH12;
    }

    public String getMSH13() {
        return MSH13;
    }

    public void setMSH13(String MSH13) {
        this.MSH13 = MSH13;
    }

    public String getMSH14() {
        return MSH14;
    }

    public void setMSH14(String MSH14) {
        this.MSH14 = MSH14;
    }

    public String getMSH15() {
        return MSH15;
    }

    public void setMSH15(String MSH15) {
        this.MSH15 = MSH15;
    }

    public String getMSH16() {
        return MSH16;
    }

    public void setMSH16(String MSH16) {
        this.MSH16 = MSH16;
    }

    public String getMSH17() {
        return MSH17;
    }

    public void setMSH17(String MSH17) {
        this.MSH17 = MSH17;
    }

    public String getMSH18() {
        return MSH18;
    }

    public void setMSH18(String MSH18) {
        this.MSH18 = MSH18;
    }

    public MSH(String MSH1, String MSH2, String MSH3, String MSH4, String MSH5, String MSH6, String MSH7, String MSH8, String MSH9, String MSH10, String MSH11, String MSH12, String MSH13, String MSH14, String MSH15, String MSH16, String MSH17, String MSH18) {
        this.MSH1 = MSH1;
        this.MSH2 = MSH2;
        this.MSH3 = MSH3;
        this.MSH4 = MSH4;
        this.MSH5 = MSH5;
        this.MSH6 = MSH6;
        this.MSH7 = MSH7;
        this.MSH8 = MSH8;
        this.MSH9 = MSH9;
        this.MSH10 = MSH10;
        this.MSH11 = MSH11;
        this.MSH12 = MSH12;
        this.MSH13 = MSH13;
        this.MSH14 = MSH14;
        this.MSH15 = MSH15;
        this.MSH16 = MSH16;
        this.MSH17 = MSH17;
        this.MSH18 = MSH18;
    }

    public MSH() {
    }

    @Override
    public String toString() {
        return   "MSH|"+
                 MSH2 + '|' +
                 MSH3 + '|' +
                 MSH4 + '|' +
                 MSH5 + '|' +
                 MSH6 + '|' +
                 MSH7 + '|' +
                 MSH8 + '|' +
                 MSH9 + '|' +
                 MSH10 + '|' +
                 MSH11 + '|' +
                 MSH12 + '|' +
                 MSH13 + '|' +
                 MSH14 + '|' +
                 MSH15 + '|' +
                 MSH16 + '|' +
                 MSH17 + '|' +
                 MSH18 +'\n' ;
    }
}
