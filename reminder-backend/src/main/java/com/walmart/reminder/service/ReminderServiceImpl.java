package com.walmart.reminder.service;

import com.walmart.reminder.converter.ReminderConverter;
import com.walmart.reminder.dao.ReminderRepository;
import com.walmart.reminder.dao.StatusRepository;
import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.dto.StatusEnum;
import com.walmart.reminder.entity.ReminderEntity;
import com.walmart.reminder.entity.StatusEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@Service
@Transactional(readOnly = true)
public class ReminderServiceImpl implements ReminderService {

    @Inject
    private ReminderRepository reminderRepository;

    @Inject
    private StatusRepository statusRepository;

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
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void updateReminder(ReminderDto reminderDto) {
        ReminderEntity entity = reminderRepository.findOne(reminderDto.getId());
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        reminderConverter.copyProperties(reminderDto, entity);
        setupStatus(reminderDto, entity);

        reminderRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ReminderDto addReminder(ReminderDto reminderDto) {
        ReminderEntity entity = reminderConverter.toEntity(reminderDto);
        setupStatus(reminderDto, entity);
        reminderRepository.save(entity);
        reminderDto.setId(entity.getId());
        return reminderDto;
    }

    private void setupStatus(ReminderDto reminderDto, ReminderEntity entity) {
        Optional.ofNullable(reminderDto.getStatus()).ifPresent(statusEnum -> {
            Optional<StatusEntity> statusOpt = statusRepository.getByCode(reminderDto.getStatus().name());
            entity.setStatus(statusOpt.orElseThrow(EntityNotFoundException::new));
        });
    }
}
