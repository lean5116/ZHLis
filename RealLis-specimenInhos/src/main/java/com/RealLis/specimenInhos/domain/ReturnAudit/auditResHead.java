package com.RealLis.specimenInhos.domain.ReturnAudit;

public class auditResHead {
    private String TradeCode;

    private String TradeTime;

    private String TradeNo;

    private String SessionId;

    private String TradeStatus;

    private String TradeMessage;

    private String BranchCode;

    private String HospitalCode;

    private String SystemCode;

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
    public void setSessionId(String SessionId){
        this.SessionId = SessionId;
    }
    public String getSessionId(){
        return this.SessionId;
    }
    public void setTradeStatus(String TradeStatus){
        this.TradeStatus = TradeStatus;
    }
    public String getTradeStatus(){
        return this.TradeStatus;
    }
    public void setTradeMessage(String TradeMessage){
        this.TradeMessage = TradeMessage;
    }
    public String getTradeMessage(){
        return this.TradeMessage;
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

    public auditResHead(String tradeCode, String tradeTime, String tradeNo, String sessionId, String tradeStatus, String tradeMessage, String branchCode, String hospitalCode, String systemCode) {
        TradeCode = tradeCode;
        TradeTime = tradeTime;
        TradeNo = tradeNo;
        SessionId = sessionId;
        TradeStatus = tradeStatus;
        TradeMessage = tradeMessage;
        BranchCode = branchCode;
        HospitalCode = hospitalCode;
        SystemCode = systemCode;
    }

    public auditResHead() {
    }
}
