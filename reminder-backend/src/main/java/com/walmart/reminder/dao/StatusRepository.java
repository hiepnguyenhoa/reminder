package com.walmart.reminder.dao;

import com.walmart.reminder.entity.StatusEntity;

import java.util.Optional;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public interface StatusRepository extends BaseRepository<StatusEntity> {

    Optional<StatusEntity> getByCode(String code);

}
