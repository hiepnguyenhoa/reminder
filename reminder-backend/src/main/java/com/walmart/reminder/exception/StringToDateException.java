package com.walmart.reminder.exception;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
public class StringToDateException extends RuntimeException{
    public StringToDateException() {
    }

    public StringToDateException(String message) {
        super(message);
    }

    public StringToDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringToDateException(Throwable cause) {
        super(cause);
    }

    public StringToDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
