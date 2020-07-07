package com.RealLis.specimenInhos.domain.PostBack;

public class PostList {
    private Long jlxh;
    private String eventName;
    private String eventData;
    private Long micType;

    public PostList(Long jlxh, String eventName, String eventData, Long micType) {
        this.jlxh = jlxh;
        this.eventName = eventName;
        this.eventData = eventData;
        this.micType = micType;
    }

    public PostList() {
    }

    public Long getJlxh() {
        return jlxh;
    }

    public void setJlxh(Long jlxh) {
        this.jlxh = jlxh;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    public Long getMicType() {
        return micType;
    }

    public void setMicType(Long micType) {
        this.micType = micType;
    }
}
