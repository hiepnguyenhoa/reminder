package com.walmart.reminder.service;

import com.walmart.reminder.converter.ReminderConverter;
import com.walmart.reminder.dao.ReminderRepository;
import com.walmart.reminder.dao.StatusRepository;
import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.dto.StatusEnum;
import com.walmart.reminder.entity.ReminderEntity;
import com.walmart.reminder.entity.StatusEntity;
import com.walmart.reminder.utils.ValidateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by HiepNguyen on 7/2/2017.
 */
@Service
@Transactional(readOnly = true)
public class ReminderServiceImpl implements ReminderService {

    private static final String ENTITY_NOT_FOUND_EXP = "Can't find out entity having id %s";

    @Inject
    private ReminderRepository reminderRepository;

    @Inject
    private StatusRepository statusRepository;

    @Inject
    private ReminderConverter reminderConverter;

    @Override
    public List<ReminderDto> getReminders(List<StatusEnum> status, Date sDate, Date eDate) {
        ValidateUtils.validateNotEmpty(status);
        ValidateUtils.validateNotNull(sDate);
        ValidateUtils.validateNotNull(eDate);
        List<StatusEntity> statusEntities = getStatusEntity_v2(status);
        List<ReminderEntity> entities = reminderRepository.filterByStatusAndDueDate(statusEntities, sDate, eDate);
        return entities.stream().map(entity -> reminderConverter.toDto(entity)).collect(Collectors.toList());
    }

    @Override
    public ReminderDto getReminderById(Long id) {
        ValidateUtils.validateNotNull(id);
        ReminderEntity entity = getReminderEntityById(id);
        return reminderConverter.toDto(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void updateReminder(ReminderDto reminderDto) {
        ValidateUtils.validateNotNull(reminderDto);
        ReminderEntity entity = getReminderEntityById(reminderDto.getId());
        reminderConverter.copyProperties(reminderDto, entity);
        setupStatus(reminderDto, entity);

        reminderRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ReminderDto addReminder(ReminderDto reminderDto) {
        ValidateUtils.validateNotNull(reminderDto);
        ReminderEntity entity = reminderConverter.toEntity(reminderDto);
        setupStatus(reminderDto, entity);
        entity = reminderRepository.save(entity);
        reminderDto.setId(entity.getId());
        return reminderDto;
    }

    private void setupStatus(ReminderDto reminderDto, ReminderEntity entity) {
        Optional.ofNullable(reminderDto.getStatus()).ifPresent(statusEnum -> {
            Optional<StatusEntity> statusOpt = statusRepository.getByCode(reminderDto.getStatus().name());
            entity.setStatus(statusOpt.orElseThrow(EntityNotFoundException::new));
        });
    }

    /**
     * I prefer to use the method but H2SQL translates <code>IN</code> to '=' condition which can't pull correct data
     * <code>select statusenti0_.id as id1_1_, statusenti0_.code as code2_1_ from REMINDER_STATUS statusenti0_ where statusenti0_.code=(? , ?)</code>
     * Work around by getStatusEntity_v2
     */
    private List<StatusEntity> getStatusEntity(List<StatusEnum> status) {
        return statusRepository.getAllByCode(status.stream().map(StatusEnum::name).collect(Collectors.toList()));
    }

    private List<StatusEntity> getStatusEntity_v2(List<StatusEnum> status) {
        return status.stream().map(StatusEnum::name).map(statusRepository::getByCode).filter(entityOpt -> entityOpt.isPresent()).map(entityOpt -> entityOpt.get()).collect(Collectors.toList());
    }

    private ReminderEntity getReminderEntityById(Long id) {
        ReminderEntity entity = reminderRepository.findOne(id);
        if (entity == null) {
            throw new EntityNotFoundException(String.format(ENTITY_NOT_FOUND_EXP, id));
        }
        return entity;
    }
}
