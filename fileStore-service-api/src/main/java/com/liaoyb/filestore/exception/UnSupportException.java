package com.liaoyb.filestore.exception;

/**
 * 不支持异常
 * @author ybliao2
 */
public class UnSupportException extends Exception {
    public UnSupportException() {
        this("不支持");
    }

    public UnSupportException(String message) {
        super(message);
    }
}
