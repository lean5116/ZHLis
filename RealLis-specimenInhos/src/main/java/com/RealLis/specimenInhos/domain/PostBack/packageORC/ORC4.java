package com.RealLis.specimenInhos.domain.PostBack.packageORC;

public class ORC4 {
    /*医嘱号*/
    private String ORC4_1="";
    /*检验主题*/
    private String ORC4_2="";

    public ORC4() {
    }

    public ORC4(String ORC4_1, String ORC4_2) {
        this.ORC4_1 = ORC4_1;
        this.ORC4_2 = ORC4_2;
    }

    public String getORC4_1() {
        return ORC4_1;
    }

    public void setORC4_1(String ORC4_1) {
        this.ORC4_1 = ORC4_1;
    }

    public String getORC4_2() {
        return ORC4_2;
    }

    public void setORC4_2(String ORC4_2) {
        this.ORC4_2 = ORC4_2;
    }

    @Override
    public String toString() {
        return  ORC4_1 + '^' +
                ORC4_2;
    }
}
