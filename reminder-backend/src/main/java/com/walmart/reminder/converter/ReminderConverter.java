package com.walmart.reminder.converter;

import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.entity.ReminderEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@Service
public class ReminderConverter implements BaseConverter<ReminderDto, ReminderEntity> {

    @Inject
    private StatusConverter statusConverter;

    @Override
    public ReminderDto toDto(ReminderEntity entity) {
        validateInput(entity);
        ReminderDto dto = new ReminderDto();
        this.copyProperties(entity, dto);
        dto.setStatus(statusConverter.toDto(entity.getStatus()));
        return dto;
    }

    @Override
    public ReminderEntity toEntity(ReminderDto reminderDto) {
        validateInput(reminderDto);
        ReminderEntity entity = new ReminderEntity();
        this.copyProperties(reminderDto, entity);
        return entity;
    }
}
