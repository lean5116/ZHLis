package com.RealLis.specimenInhos.domain.PostBack.packageORC;

public class ORC19 {
    /*执行科室代码*/
    private String ORC19_1="";
    /*执行科室名*/
    private String ORC19_2="";

    public String getORC19_1() {
        return ORC19_1;
    }

    public void setORC19_1(String ORC19_1) {
        this.ORC19_1 = ORC19_1;
    }

    public String getORC19_2() {
        return ORC19_2;
    }

    public void setORC19_2(String ORC19_2) {
        this.ORC19_2 = ORC19_2;
    }

    public ORC19() {
    }

    public ORC19(String ORC19_1, String ORC19_2) {
        this.ORC19_1 = ORC19_1;
        this.ORC19_2 = ORC19_2;
    }

    @Override
    public String toString() {
        return  ORC19_1 + '^' +
                ORC19_2 ;
    }
}
