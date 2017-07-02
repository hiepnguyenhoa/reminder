package com.walmart.reminder.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 5692772093194337950L;

    protected Long id;

    protected TimeZone timeZone;
    protected LocalDateTime createdOn;
    protected LocalDateTime updatedOn;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
