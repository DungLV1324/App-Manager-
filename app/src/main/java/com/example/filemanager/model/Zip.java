package com.example.filemanager.model;

public class Zip {
    private String nameZip;
    private String dateZip;

    public Zip(String nameZip, String dateZip) {
        this.nameZip = nameZip;
        this.dateZip = dateZip;
    }
    public String getDateZip() {
        return dateZip;
    }

    public void setDateZip(String dateZip) {
        this.dateZip = dateZip;
    }

    public String getNameZip() {
        return nameZip;
    }

    public void setNameZip(String nameZip) {
        this.nameZip = nameZip;
    }
    @Override
    public String toString() {
        return "Zip{" +
                "nameZip='" + nameZip + '\'' +
                ", dateZip='" + dateZip + '\'' +
                '}';
    }
}
