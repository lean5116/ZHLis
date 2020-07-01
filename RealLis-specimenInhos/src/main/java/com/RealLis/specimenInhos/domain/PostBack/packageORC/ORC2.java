package com.RealLis.specimenInhos.domain.PostBack.packageORC;

public class ORC2 {
    /*医嘱号*/
    private String ORC2_1="";
    /*发起参数 LIS*/
    private String ORC2_2="";

    public ORC2(String ORC2_1, String ORC2_2) {
        this.ORC2_1 = ORC2_1;
        this.ORC2_2 = ORC2_2;
    }

    public ORC2() {
    }

    public String getORC2_1() {
        return ORC2_1;
    }

    public void setORC2_1(String ORC2_1) {
        this.ORC2_1 = ORC2_1;
    }

    public String getORC2_2() {
        return ORC2_2;
    }

    public void setORC2_2(String ORC2_2) {
        this.ORC2_2 = ORC2_2;
    }

    @Override
    public String toString() {
        return  ORC2_1 + '^' +
                ORC2_2 ;
    }
}
