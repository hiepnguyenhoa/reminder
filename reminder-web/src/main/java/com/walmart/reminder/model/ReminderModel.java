package com.walmart.reminder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by HiepNguyen on 7/4/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReminderModel implements Serializable{

    private static final long serialVersionUID = -188688462698736297L;

    private Long id;
    private String remindContent;
    private Date dueDate;
    private String status;

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }
    
    

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

      public String getStatus() {
            return status;
      }

      public void setStatus(String status) {
            this.status = status;
      }
    
    
}
