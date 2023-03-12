package com.example.filemanager.model;

public class Download {
    private String nameDownload;
    private String dateDownload;

    public Download(String nameDownload, String dateDownload) {
        this.nameDownload = nameDownload;
        this.dateDownload = dateDownload;
    }

    @Override
    public String toString() {
        return "Download{" +
                "nameDownload='" + nameDownload + '\'' +
                ", dateDownload='" + dateDownload + '\'' +
                '}';
    }

    public String getNameDownload() {
        return nameDownload;
    }

    public void setNameDownload(String nameDownload) {
        this.nameDownload = nameDownload;
    }

    public String getDateDownload() {
        return dateDownload;
    }

    public void setDateDownload(String dateDownload) {
        this.dateDownload = dateDownload;
    }
}
