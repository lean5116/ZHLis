package com.RealLis.specimenInhos.domain.ReturnAudit;

public class auditRes {
    private auditResHead Head;

    public void setHead(auditResHead Head){
        this.Head = Head;
    }
    public auditResHead getHead(){
        return this.Head;
    }

    public auditRes(auditResHead head) {
        Head = head;
    }

    public auditRes() {
    }
}
