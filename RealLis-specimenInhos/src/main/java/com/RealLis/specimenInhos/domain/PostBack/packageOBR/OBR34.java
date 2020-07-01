package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR34 {
    /*执行者ID*/
    private String OBR34_1="";
    /*执行者姓名*/
    private String OBR34_2="";

    public OBR34(String OBR34_1, String OBR34_2) {
        this.OBR34_1 = OBR34_1;
        this.OBR34_2 = OBR34_2;
    }

    public OBR34() {
    }

    public String getOBR34_1() {
        return OBR34_1;
    }

    public void setOBR34_1(String OBR34_1) {
        this.OBR34_1 = OBR34_1;
    }

    public String getOBR34_2() {
        return OBR34_2;
    }

    public void setOBR34_2(String OBR34_2) {
        this.OBR34_2 = OBR34_2;
    }

    @Override
    public String toString() {
        return  OBR34_1 + '^' +
                OBR34_2 ;
    }
}
