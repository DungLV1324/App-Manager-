package com.example.filemanager.data.model;

public class ItemFile {

    private String path;

    public ItemFile(String path) {
        this.path = path;
    }

    public ItemFile cloneValue() {
        ItemFile itemFile = new ItemFile(path);
        return itemFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ItemFile{" +
                "path='" + path + '\'' +
                '}';
    }
}
