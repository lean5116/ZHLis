package com.RealLis.specimenInhos.domain.PostBack.packageORC;

public class ORC13 {
    /*申请科室代码*/
    private String ORC13_1="";
    /*申请科室名称*/
    private String ORC13_2="";

    public ORC13() {
    }

    public ORC13(String ORC13_1, String ORC13_2) {
        this.ORC13_1 = ORC13_1;
        this.ORC13_2 = ORC13_2;
    }

    public String getORC13_1() {
        return ORC13_1;
    }

    public void setORC13_1(String ORC13_1) {
        this.ORC13_1 = ORC13_1;
    }

    public String getORC13_2() {
        return ORC13_2;
    }

    public void setORC13_2(String ORC13_2) {
        this.ORC13_2 = ORC13_2;
    }

    @Override
    public String toString() {
        return  ORC13_1 + '^' +
                ORC13_2 ;
    }
}
