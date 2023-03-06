package com.example.filemanager.modle;

public class Zip {
    private String nameZip;

    public Zip(String nameZip) {
        this.nameZip = nameZip;
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
                '}';
    }
}
