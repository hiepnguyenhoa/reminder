package com.walmart.reminder.dto;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public enum StatusEnum {
    NOT_DONE("NOTDONE"),
    DONE("DONE");

    private String code;

    private StatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
