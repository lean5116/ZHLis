package com.RealLis.specimenInhos.domain;

public class Packing {
    private String rtncode;
    private String rtntext;
    private String bqmc;
    private String cjsj;
    private String bbsl;

    public Packing(String rtncode, String rtntext, String bqmc, String cjsj, String bbsl) {
        this.rtncode = rtncode;
        this.rtntext = rtntext;
        this.bqmc = bqmc;
        this.cjsj = cjsj;
        this.bbsl = bbsl;
    }

    public String getRtncode() {
        return rtncode;
    }

    public void setRtncode(String rtncode) {
        this.rtncode = rtncode;
    }

    public String getRtntext() {
        return rtntext;
    }

    public void setRtntext(String rtntext) {
        this.rtntext = rtntext;
    }

    public String getBqmc() {
        return bqmc;
    }

    public void setBqmc(String bqmc) {
        this.bqmc = bqmc;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getBbsl() {
        return bbsl;
    }

    public void setBbsl(String bbsl) {
        this.bbsl = bbsl;
    }

    public Packing() {
    }
}
