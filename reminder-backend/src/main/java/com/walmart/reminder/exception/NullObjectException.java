package com.walmart.reminder.exception;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
public class NullObjectException extends RuntimeException{
    public NullObjectException() {
    }

    public NullObjectException(String message) {
        super(message);
    }

    public NullObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullObjectException(Throwable cause) {
        super(cause);
    }

    public NullObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
