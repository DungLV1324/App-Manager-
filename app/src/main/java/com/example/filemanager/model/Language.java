package com.example.filemanager.model;

public class Language {
    private String nameLanguage;

    public Language(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public void setNameLanguage(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }

    @Override
    public String toString() {
        return "Language{" +
                "nameLanguage='" + nameLanguage + '\'' +
                '}';
    }
}
