package com.walmart.reminder.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity implements Serializable {

    public static final long serialVersionUID = -5253115899312219411L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
