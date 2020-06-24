package com.RealLis.specimenInhos.domain;

public class Formatter {
    private String Text;
    private String Value;

    public Formatter(String text, String value) {
        Text = text;
        Value = value;
    }

    public Formatter() {
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
