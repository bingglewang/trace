package com.zsl.traceapi.dto;

import java.io.File;

public class FileInfo {
    private String path;
    private String name;
    private String type;
    private String size;

    public FileInfo() {
    }

    public FileInfo(File file) {
        this.path = file.getPath();
        this.name = file.getName();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
