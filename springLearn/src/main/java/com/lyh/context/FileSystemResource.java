package com.lyh.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lvyanghui
 * 2019/2/15 11:33
 */
public class FileSystemResource implements Resource{

    private File file;

    public FileSystemResource(String location) {
        this.file = new File(location);
    }

    public FileSystemResource(File file) {
        this.file = file;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public boolean isReadable() {
        return file.canRead();
    }

    @Override
    public boolean isOpen() {
        return file.canRead();
    }

    @Override
    public File getFile() {
        return file;
    }
}
