package com.walmart.reminder.dao;

import com.walmart.reminder.entity.ReminderEntity;
import com.walmart.reminder.entity.StatusEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public interface ReminderRepository extends BaseRepository<ReminderEntity> {

    @Query("SELECT r FROM ReminderEntity r WHERE r.status IN (:status) AND r.dueDate>=:sDate AND r.dueDate<=:eDate")
    List<ReminderEntity> filterByStatusAndDueDate(@Param("status") List<StatusEntity> status, @Param("sDate") Date sDate, @Param("eDate") Date eDate);

}
