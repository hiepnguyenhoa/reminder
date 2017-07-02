package com.walmart.reminder.service;

import com.walmart.reminder.dto.ReminderDto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
public interface ReminderService {

    List<ReminderDto> getReminders();

    ReminderDto getReminderById(@NotNull Long id);

    void updateReminder(@NotNull ReminderDto reminderDto);

    ReminderDto addReminder(@NotNull ReminderDto reminderDto);
}
