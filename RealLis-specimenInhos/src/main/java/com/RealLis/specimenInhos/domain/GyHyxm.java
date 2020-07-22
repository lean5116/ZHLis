package com.RealLis.specimenInhos.domain;

public class GyHyxm {
    private String hyxm;
    private String bgbs;

    public String getHyxm() {
        return hyxm;
    }

    public void setHyxm(String hyxm) {
        this.hyxm = hyxm;
    }

    public String getBgbs() {
        return bgbs;
    }

    public void setBgbs(String bgbs) {
        this.bgbs = bgbs;
    }

    public GyHyxm(String hyxm, String bgbs) {
        this.hyxm = hyxm;
        this.bgbs = bgbs;
    }

    public GyHyxm() {
    }
}
