package com.walmart.reminder.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = -5253115899312219411L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
