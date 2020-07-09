package com.RealLis.specimenInhos.domain.ReturnAudit;

public class auditHead {
    private String TradeCode;

    private String TradeTime;

    private String TradeNo;

    private String BranchCode;

    private String HospitalCode;

    private String SystemCode;

    private String HipKeyNo;

    public void setTradeCode(String TradeCode){
        this.TradeCode = TradeCode;
    }
    public String getTradeCode(){
        return this.TradeCode;
    }
    public void setTradeTime(String TradeTime){
        this.TradeTime = TradeTime;
    }
    public String getTradeTime(){
        return this.TradeTime;
    }
    public void setTradeNo(String TradeNo){
        this.TradeNo = TradeNo;
    }
    public String getTradeNo(){
        return this.TradeNo;
    }
    public void setBranchCode(String BranchCode){
        this.BranchCode = BranchCode;
    }
    public String getBranchCode(){
        return this.BranchCode;
    }
    public void setHospitalCode(String HospitalCode){
        this.HospitalCode = HospitalCode;
    }
    public String getHospitalCode(){
        return this.HospitalCode;
    }
    public void setSystemCode(String SystemCode){
        this.SystemCode = SystemCode;
    }
    public String getSystemCode(){
        return this.SystemCode;
    }
    public void setHipKeyNo(String HipKeyNo){
        this.HipKeyNo = HipKeyNo;
    }
    public String getHipKeyNo(){
        return this.HipKeyNo;
    }

    public auditHead(String tradeCode, String tradeTime, String tradeNo, String branchCode, String hospitalCode, String systemCode, String hipKeyNo) {
        TradeCode = tradeCode;
        TradeTime = tradeTime;
        TradeNo = tradeNo;
        BranchCode = branchCode;
        HospitalCode = hospitalCode;
        SystemCode = systemCode;
        HipKeyNo = hipKeyNo;
    }

    public auditHead() {
    }

    @Override
    public String toString() {
        return "\"Head\":{" +
                "\"TradeCode\":\"" + TradeCode + '\"' +
                ", \"TradeTime\":\"" + TradeTime + '\"' +
                ", \"TradeNo\":\"" + TradeNo + '\"' +
                ", \"BranchCode\":\"" + BranchCode + '\"' +
                ", \"HospitalCode\":\"" + HospitalCode + '\"' +
                ", \"SystemCode\":\"" + SystemCode + '\"' +
                ", \"HipKeyNo\":\"" + HipKeyNo + '\"' +
                '}';
    }
}
