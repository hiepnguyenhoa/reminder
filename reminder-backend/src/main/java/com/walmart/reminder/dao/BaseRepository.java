package com.walmart.reminder.dao;

import com.walmart.reminder.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
