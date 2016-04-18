package com.liaoyb.filestore.exception;

/**
 * 文件不存在
 * @author ybliao2
 */
public class FileNotExistException  extends Exception{
    public FileNotExistException() {
        this("文件不存在");
    }

    public FileNotExistException(String message) {
        super(message);
    }
}
