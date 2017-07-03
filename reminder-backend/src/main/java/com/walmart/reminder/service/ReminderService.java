package com.walmart.reminder.service;

import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.dto.StatusEnum;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public interface ReminderService {

    //    List<ReminderDto> getReminders(EnumSet<StatusEnum> status, Date sDate, Date eDate);
    List<ReminderDto> getReminders(List<StatusEnum> status, Date sDate, Date eDate);

    ReminderDto getReminderById(@NotNull Long id);

    void updateReminder(@NotNull ReminderDto reminderDto);

    ReminderDto addReminder(@NotNull ReminderDto reminderDto);
}
