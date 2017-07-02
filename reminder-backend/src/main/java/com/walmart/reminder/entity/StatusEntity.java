package com.walmart.reminder.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@Entity
@Table(name = "REMINDER_STATUS")
public class StatusEntity extends BaseEntity{

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
