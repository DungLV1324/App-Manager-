package com.example.filemanager.modle;

public class Apk {
    private String nameApk;
    private  String dateApk;

    public String getDateApk() {
        return dateApk;
    }

    public void setDateApk(String date) {
        this.dateApk = date;
    }

    public String getNameApk() {
        return nameApk;
    }

    public void setNameApk(String nameApk) {
        this.nameApk = nameApk;
    }

    public Apk(String nameApk, String dateApk) {
        this.nameApk = nameApk;
        this.dateApk = dateApk;
    }

    @Override
    public String toString() {
        return "Apk{" +
                "nameImage='" + nameApk + '\'' +
                ", dateApk='" + dateApk + '\'' +
                '}';
    }
}
