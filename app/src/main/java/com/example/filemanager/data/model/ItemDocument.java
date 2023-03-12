package com.example.filemanager.data.model;

import com.example.filemanager.util.DateUtil;
import com.example.filemanager.util.StorageUtils;

public class ItemDocument {
    private String nameFile;
    private String nameFolder;
    private long size;
    private String category;
    private String path;
    private String fileId;
    private long timeModified;
    private long timeAdded;

    public ItemDocument() {
    }

    public long getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(long timeAdded) {
        this.timeAdded = timeAdded;
    }

    public ItemDocument cloneValue() {
        ItemDocument itemDocument1 = new ItemDocument();
        itemDocument1.setNameFile(nameFile);
        itemDocument1.setNameFolder(nameFolder);
        itemDocument1.setSize(size);
        itemDocument1.setCategory(category);
        itemDocument1.setPath(path);
        itemDocument1.setFileId(fileId);
        itemDocument1.setTimeModified(timeModified);
        itemDocument1.setTimeAdded(timeAdded);
        return itemDocument1;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getNameFolder() {
        return nameFolder;
    }

    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public long getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(long timeModified) {
        this.timeModified = timeModified;
    }

    @Override
    public String toString() {
        return "ItemDocument{" +
                "\nnameFile='" + nameFile + '\'' +
                "\nnameFolder='" + nameFolder + '\'' +
                "\nsize=" + size + "--to string: " + StorageUtils.readableFileSize(size) +
                "\ncategory='" + category + '\'' +
                "\npath='" + path + '\'' +
                "\nfileId='" + fileId + '\'' +
                "\ntimeModified=" + timeModified +"--to Date: "+ DateUtil.formatTime(timeModified,"hh:ss, dd/MM/yyyy")+
                "\ntimeAdded=" + timeAdded +"--to Date: "+ DateUtil.formatTime(timeAdded,"hh:ss, dd/MM/yyyy")+
                '}'+"\n---------------------------------";
    }
}
