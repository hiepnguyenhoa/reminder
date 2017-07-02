package com.walmart.reminder.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@Entity
@Table(name = "REMINDER")
public class ReminderEntity extends BaseEntity{

    private String remindContent;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;

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

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
}
