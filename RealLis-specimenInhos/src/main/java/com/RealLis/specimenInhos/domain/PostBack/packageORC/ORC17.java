package com.RealLis.specimenInhos.domain.PostBack.packageORC;

public class ORC17 {
    /*申请科室Id*/
    private String ORC17_1="";
    /*申请科室名称*/
    private String ORC17_2="";

    public ORC17() {
    }

    public ORC17(String ORC17_1, String ORC17_2) {
        this.ORC17_1 = ORC17_1;
        this.ORC17_2 = ORC17_2;
    }

    public String getORC17_1() {
        return ORC17_1;
    }

    public void setORC17_1(String ORC17_1) {
        this.ORC17_1 = ORC17_1;
    }

    public String getORC17_2() {
        return ORC17_2;
    }

    public void setORC17_2(String ORC17_2) {
        this.ORC17_2 = ORC17_2;
    }

    @Override
    public String toString() {
        return  ORC17_1 + '^' +
                ORC17_2 ;
    }
}
