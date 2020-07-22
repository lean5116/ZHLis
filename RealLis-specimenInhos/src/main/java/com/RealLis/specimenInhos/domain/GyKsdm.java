package com.RealLis.specimenInhos.domain;

public class GyKsdm {
    private String ksdm;
    private String ksmc;

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public GyKsdm() {
    }

    public GyKsdm(String ksdm, String ksmc) {
        this.ksdm = ksdm;
        this.ksmc = ksmc;
    }
}
