package com.example.filemanager.model;

public class Recent {
    private String nameItemRecent;
    private String dateItemRecent;

    public Recent(String nameItemRecent, String dateItemRecent) {
        this.nameItemRecent = nameItemRecent;
        this.dateItemRecent = dateItemRecent;
    }

    public String getNameItemRecent() {
        return nameItemRecent;
    }

    public void setNameItemRecent(String nameItemRecent) {
        this.nameItemRecent = nameItemRecent;
    }

    public String getDateItemRecent() {
        return dateItemRecent;
    }

    public void setDateItemRecent(String dateItemRecent) {
        this.dateItemRecent = dateItemRecent;
    }

    @Override
    public String toString() {
        return "recent{" +
                "nameItemRecent='" + nameItemRecent + '\'' +
                ", dateItemRecent='" + dateItemRecent + '\'' +
                '}';
    }
}
