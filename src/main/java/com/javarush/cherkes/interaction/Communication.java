package com.javarush.cherkes.interaction;

import java.io.File;

public class Communication {

    private String path = System.getProperty("user.dir") + File.separator;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
