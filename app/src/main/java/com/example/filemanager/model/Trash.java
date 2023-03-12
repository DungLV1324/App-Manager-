package com.example.filemanager.model;

public class Trash {
    private String nameTrash;
    private String dateTrash;

    public Trash(String nameTrash, String dateTrash) {
        this.nameTrash = nameTrash;
        this.dateTrash = dateTrash;
    }

    @Override
    public String toString() {
        return "Trash{" +
                "nameTrash='" + nameTrash + '\'' +
                ", dateTrash='" + dateTrash + '\'' +
                '}';
    }

    public String getNameTrash() {
        return nameTrash;
    }

    public void setNameTrash(String nameTrash) {
        this.nameTrash = nameTrash;
    }

    public String getDateTrash() {
        return dateTrash;
    }

    public void setDateTrash(String dateTrash) {
        this.dateTrash = dateTrash;
    }
}
