package com.RealLis.specimenInhos.domain.PostBack.reportPostBack;

import com.RealLis.specimenInhos.domain.PostBack.reportPostBack.packageOBX.OBX3;

public class OBX {
    /*序号*/
    private String OBX1="";
    /*结果类型*/
    private String OBX2="";
    /*检测项目*/
    private OBX3 OBX3 =new OBX3();
    /*打印顺序*/
    private String OBX4="";
    /*结果值*/
    private String OBX5="";
    /*单位*/
    private String OBX6="";
    /*检验结果上下限*/
    private String OBX7="";
    /*结果正常标志*/
    private String OBX8="";
    /**/
    private String OBX9="";
    /**/
    private String OBX10="";
    /**/
    private String OBX11="";
    /**/
    private String OBX12="";
    /**/
    private String OBX13="";
    /**/
    private String OBX14="";
    /*用于和临床意义关联*/
    private String OBX15="";
    /**/
    private String OBX16="";
    /**/
    private String OBX17="";
    /**/
    private String OBX18="";
    /*检验日期*/
    private String OBX19;

    public OBX(String OBX1, String OBX2, com.RealLis.specimenInhos.domain.PostBack.reportPostBack.packageOBX.OBX3 OBX3, String OBX4, String OBX5, String OBX6, String OBX7, String OBX8, String OBX9, String OBX10, String OBX11, String OBX12, String OBX13, String OBX14, String OBX15, String OBX16, String OBX17, String OBX18, String OBX19) {
        this.OBX1 = OBX1;
        this.OBX2 = OBX2;
        this.OBX3 = OBX3;
        this.OBX4 = OBX4;
        this.OBX5 = OBX5;
        this.OBX6 = OBX6;
        this.OBX7 = OBX7;
        this.OBX8 = OBX8;
        this.OBX9 = OBX9;
        this.OBX10 = OBX10;
        this.OBX11 = OBX11;
        this.OBX12 = OBX12;
        this.OBX13 = OBX13;
        this.OBX14 = OBX14;
        this.OBX15 = OBX15;
        this.OBX16 = OBX16;
        this.OBX17 = OBX17;
        this.OBX18 = OBX18;
        this.OBX19 = OBX19;
    }

    public OBX() {
    }

    public String getOBX1() {
        return OBX1;
    }

    public void setOBX1(String OBX1) {
        this.OBX1 = OBX1;
    }

    public String getOBX2() {
        return OBX2;
    }

    public void setOBX2(String OBX2) {
        this.OBX2 = OBX2;
    }

    public com.RealLis.specimenInhos.domain.PostBack.reportPostBack.packageOBX.OBX3 getOBX3() {
        return OBX3;
    }

    public void setOBX3(com.RealLis.specimenInhos.domain.PostBack.reportPostBack.packageOBX.OBX3 OBX3) {
        this.OBX3 = OBX3;
    }

    public String getOBX4() {
        return OBX4;
    }

    public void setOBX4(String OBX4) {
        this.OBX4 = OBX4;
    }

    public String getOBX5() {
        return OBX5;
    }

    public void setOBX5(String OBX5) {
        this.OBX5 = OBX5;
    }

    public String getOBX6() {
        return OBX6;
    }

    public void setOBX6(String OBX6) {
        this.OBX6 = OBX6;
    }

    public String getOBX7() {
        return OBX7;
    }

    public void setOBX7(String OBX7) {
        this.OBX7 = OBX7;
    }

    public String getOBX8() {
        return OBX8;
    }

    public void setOBX8(String OBX8) {
        this.OBX8 = OBX8;
    }

    public String getOBX9() {
        return OBX9;
    }

    public void setOBX9(String OBX9) {
        this.OBX9 = OBX9;
    }

    public String getOBX10() {
        return OBX10;
    }

    public void setOBX10(String OBX10) {
        this.OBX10 = OBX10;
    }

    public String getOBX11() {
        return OBX11;
    }

    public void setOBX11(String OBX11) {
        this.OBX11 = OBX11;
    }

    public String getOBX12() {
        return OBX12;
    }

    public void setOBX12(String OBX12) {
        this.OBX12 = OBX12;
    }

    public String getOBX13() {
        return OBX13;
    }

    public void setOBX13(String OBX13) {
        this.OBX13 = OBX13;
    }

    public String getOBX14() {
        return OBX14;
    }

    public void setOBX14(String OBX14) {
        this.OBX14 = OBX14;
    }

    public String getOBX15() {
        return OBX15;
    }

    public void setOBX15(String OBX15) {
        this.OBX15 = OBX15;
    }

    public String getOBX16() {
        return OBX16;
    }

    public void setOBX16(String OBX16) {
        this.OBX16 = OBX16;
    }

    public String getOBX17() {
        return OBX17;
    }

    public void setOBX17(String OBX17) {
        this.OBX17 = OBX17;
    }

    public String getOBX18() {
        return OBX18;
    }

    public void setOBX18(String OBX18) {
        this.OBX18 = OBX18;
    }

    public String getOBX19() {
        return OBX19;
    }

    public void setOBX19(String OBX19) {
        this.OBX19 = OBX19;
    }

    @Override
    public String toString() {
        return "OBX|" +
                 OBX1 + '|' +
                 OBX2 + '|' +
                 OBX3.toString() +'|'+
                 OBX4 + '|' +
                 OBX5 + '|' +
                 OBX6 + '|' +
                 OBX7 + '|' +
                 OBX8 + '|' +
                 OBX9 + '|' +
                 OBX10 + '|' +
                 OBX11 + '|' +
                 OBX12 + '|' +
                 OBX13 + '|' +
                 OBX14 + '|' +
                 OBX15 + '|' +
                 OBX16 + '|' +
                 OBX17 + '|' +
                 OBX18 + '|' +
                 OBX19 +'\n';
    }
}
