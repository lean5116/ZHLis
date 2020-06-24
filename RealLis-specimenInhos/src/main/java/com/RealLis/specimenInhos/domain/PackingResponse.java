package com.RealLis.specimenInhos.domain;

public class PackingResponse {
    private Packing Body;

    public Packing getBody() {
        return Body;
    }

    public void setBody(Packing body) {
        Body = body;
    }

    public PackingResponse() {
    }

    public PackingResponse(Packing body) {
        Body = body;
    }
}
