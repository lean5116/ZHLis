package com.RealLis.specimenInhos.domain.PostBack.packageORC;

public class ORC12 {
    /*申请医生ID*/
    private String ORC12_1="";
    /*申请医生姓名*/
    private String ORC12_2="";

    public ORC12(String ORC12_1, String ORC12_2) {
        this.ORC12_1 = ORC12_1;
        this.ORC12_2 = ORC12_2;
    }

    public ORC12() {
    }

    public String getORC12_1() {
        return ORC12_1;
    }

    public void setORC12_1(String ORC12_1) {
        this.ORC12_1 = ORC12_1;
    }

    public String getORC12_2() {
        return ORC12_2;
    }

    public void setORC12_2(String ORC12_2) {
        this.ORC12_2 = ORC12_2;
    }

    @Override
    public String toString() {
        return  ORC12_1 + '^' +
                ORC12_2;
    }
}
