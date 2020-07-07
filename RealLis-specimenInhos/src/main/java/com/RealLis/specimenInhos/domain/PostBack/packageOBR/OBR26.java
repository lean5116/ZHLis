package com.RealLis.specimenInhos.domain.PostBack.packageOBR;

public class OBR26 {
    private String OBR26_1="";
    private String OBR26_2="";

    public OBR26(String OBR26_1, String OBR26_2) {
        this.OBR26_1 = OBR26_1;
        this.OBR26_2 = OBR26_2;
    }

    public String getOBR26_1() {
        return OBR26_1;
    }

    public void setOBR26_1(String OBR26_1) {
        this.OBR26_1 = OBR26_1;
    }

    public String getOBR26_2() {
        return OBR26_2;
    }

    public void setOBR26_2(String OBR26_2) {
        this.OBR26_2 = OBR26_2;
    }

    public OBR26() {
    }

    @Override
    public String toString() {
        return  OBR26_1 + '^' +
                OBR26_2 ;
    }
}
