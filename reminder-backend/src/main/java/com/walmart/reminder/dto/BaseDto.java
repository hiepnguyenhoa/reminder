package com.walmart.reminder.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public class BaseDto implements Serializable {

    public static final long serialVersionUID = 5692772093194337950L;

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
