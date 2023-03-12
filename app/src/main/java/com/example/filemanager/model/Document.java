package com.example.filemanager.model;

public class Document {

    private String nameDocument;
    private String dateDocument;

    public Document(String nameDocument, String dateDocument) {
        this.nameDocument = nameDocument;
        this.dateDocument = dateDocument;
    }

    @Override
    public String toString() {
        return "Document{" +
                "nameDocument='" + nameDocument + '\'' +
                ", dateDocument='" + dateDocument + '\'' +
                '}';
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public String getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(String dateDocument) {
        this.dateDocument = dateDocument;
    }
}
