package com.walmart.reminder.exception;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
public class NotNullException extends RuntimeException {
    public NotNullException() {
    }

    public NotNullException(String message) {
        super(message);
    }

    public NotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotNullException(Throwable cause) {
        super(cause);
    }

    public NotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
