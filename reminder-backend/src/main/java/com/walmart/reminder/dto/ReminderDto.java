package com.walmart.reminder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@XmlRootElement
public class ReminderDto extends BaseDto {

    private String remindContent;

    private Date dueDate;

    private StatusEnum status;

    public String getRemindContent() {
        return remindContent;
    }

    public void setRemindContent(String remindContent) {
        this.remindContent = remindContent;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
