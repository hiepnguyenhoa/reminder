package com.walmart.reminder.service;

import com.walmart.reminder.converter.ReminderConverter;
import com.walmart.reminder.dao.ReminderRepository;
import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.entity.ReminderEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@Service
@Transactional(readOnly = true)
public class ReminderServiceImpl implements ReminderService {

    @Inject
    private ReminderRepository reminderRepository;

    @Inject
    private ReminderConverter reminderConverter;

    @Override
    public List<ReminderDto> getReminders() {
        List<ReminderEntity> entities = reminderRepository.findAll();
        List<ReminderDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(reminderConverter.toDto(e)));
        return dtos;
    }

    @Override
    public ReminderDto getReminderById(Long id) {
        return reminderConverter.toDto(reminderRepository.findOne(id));
    }

    @Override
    public void updateReminder(ReminderDto reminderDto) {

    }

    @Override
    public ReminderDto addReminder(ReminderDto reminderDto) {
        return new ReminderDto();
    }
}
