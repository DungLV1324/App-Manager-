package com.example.filemanager.common;

public class MessageEvent {
    private int typeEvent = 0;
    private String stringValue = "";
    private int intValue = -1;

    public MessageEvent(int typeEvent) {
        this.typeEvent = typeEvent;
    }

    public int getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(int typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}