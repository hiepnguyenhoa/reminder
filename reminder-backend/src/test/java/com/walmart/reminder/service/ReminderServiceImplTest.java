package com.walmart.reminder.service;

import com.walmart.reminder.converter.ReminderConverter;
import com.walmart.reminder.dao.ReminderRepository;
import com.walmart.reminder.dao.StatusRepository;
import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.dto.StatusEnum;
import com.walmart.reminder.entity.ReminderEntity;
import com.walmart.reminder.entity.StatusEntity;
import com.walmart.reminder.exception.EmptyException;
import com.walmart.reminder.exception.NullObjectException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ReminderServiceImplTest {

    @InjectMocks
    private ReminderServiceImpl reminderService;

    @Mock
    private ReminderRepository reminderRepository;

    @Mock
    private StatusRepository statusRepository;

    /**
     * I prefer to mark the object as a <code>Spy</code> object.
     * However due to version 1.9.x doesn't support default method in Java 8, change to use as a mock object.
     * Converter must have is own tests.
     */
    //TODO: change to use Spy when Mokito version 2.0 stable.
    @Mock
    private ReminderConverter reminderConverter;

    @Test
    public void getReminders() {
        int size = 5;
        when(reminderRepository.filterByStatusAndDueDate(anyList(), any(Date.class), any(Date.class))).thenReturn(reminderEntities(size));
        when(statusRepository.getByCode(anyString())).thenReturn(Optional.of(new StatusEntity()));
        when(reminderConverter.toDto(any(ReminderEntity.class))).thenReturn(new ReminderDto());

        List<ReminderDto> dtos = reminderService.getReminders(statusEnumList(), new Date(), new Date());
        assertEquals("Expected same size", size, dtos.size());
    }

    @Test(expected = NullObjectException.class)
    public void getReminders_NullStatus() {
        int size = 5;
        when(reminderRepository.filterByStatusAndDueDate(anyList(), any(Date.class), any(Date.class))).thenReturn(reminderEntities(size));
        reminderService.getReminders(null, new Date(), new Date());
    }

    @Test(expected = EmptyException.class)
    public void getReminders_EmptyStatus() {
        int size = 5;
        when(reminderRepository.filterByStatusAndDueDate(anyList(), any(Date.class), any(Date.class))).thenReturn(reminderEntities(size));
        reminderService.getReminders(new ArrayList<>(), new Date(), new Date());
    }

    @Test(expected = NullObjectException.class)
    public void getReminders_NullStartDate() {
        int size = 5;
        when(reminderRepository.filterByStatusAndDueDate(anyList(), any(Date.class), any(Date.class))).thenReturn(reminderEntities(size));
        reminderService.getReminders(statusEnumList(), null, new Date());
    }

    @Test(expected = NullObjectException.class)
    public void getReminders_NullEndDate() {
        int size = 5;
        when(reminderRepository.filterByStatusAndDueDate(anyList(), any(Date.class), any(Date.class))).thenReturn(reminderEntities(size));
        reminderService.getReminders(statusEnumList(), new Date(), null);
    }

    @Test
    public void getReminderById() {
        when(reminderRepository.findOne(anyLong())).thenReturn(new ReminderEntity());
        when(reminderConverter.toDto(anyObject())).thenReturn(new ReminderDto());

        ReminderDto dto = reminderService.getReminderById(anyLong());
        assertNotNull(dto);
    }

    @Test(expected = EntityNotFoundException.class)
    public void getReminderById_EntityNotFound() {
        when(reminderRepository.findOne(anyLong())).thenReturn(null);
        ReminderDto dto = reminderService.getReminderById(anyLong());
    }

    @Test(expected = NullObjectException.class)
    public void getReminderById_NullObjectException() {
        when(reminderRepository.findOne(anyLong())).thenReturn(new ReminderEntity());
        ReminderDto dto = reminderService.getReminderById(null);
    }

    @Test
    public void updateReminder() {
        ReminderEntity entity = new ReminderEntity();
        entity.setId(1L);
        when(reminderRepository.findOne(anyLong())).thenReturn(entity);
        when(reminderRepository.save(any(ReminderEntity.class))).thenReturn(entity);

        ReminderDto reminderDto = new ReminderDto();
        reminderDto.setId(1L);
        reminderService.updateReminder(reminderDto);
        verify(reminderRepository, times(1)).findOne(anyLong());
        verify(reminderRepository, times(1)).save(any(ReminderEntity.class));
    }

    @Test(expected = EntityNotFoundException.class)
    public void updateReminder_EntityNotFoundException() {
        when(reminderRepository.findOne(anyLong())).thenReturn(null);

        ReminderDto reminderDto = new ReminderDto();
        reminderDto.setId(1L);
        reminderService.updateReminder(reminderDto);
        verify(reminderRepository, times(1)).findOne(anyLong());
        verify(reminderRepository, never()).save(any(ReminderEntity.class));
    }

    @Test
    public void addReminder() {
        ReminderEntity entity = new ReminderEntity();
        entity.setId(1L);
        when(reminderRepository.save(any(ReminderEntity.class))).thenReturn(entity);

        ReminderDto reminderDto = new ReminderDto();
        reminderService.addReminder(reminderDto);
        verify(reminderRepository, never()).findOne(anyLong());
        verify(reminderRepository, times(1)).save(any(ReminderEntity.class));
    }

    @Test(expected = RuntimeException.class)
    public void addReminder_Excpetion() {
        when(reminderRepository.save(any(ReminderEntity.class))).thenThrow(new RuntimeException());

        ReminderDto reminderDto = new ReminderDto();
        reminderService.addReminder(reminderDto);
        verify(reminderRepository, never()).findOne(anyLong());
        verify(reminderRepository, never()).findOne(anyLong());
        verify(reminderRepository, never()).findOne(anyLong());
        verify(reminderRepository, times(1)).save(any(ReminderEntity.class));
    }

    private List<ReminderEntity> reminderEntities(int size) {
        List<ReminderEntity> reminderEntities = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            reminderEntities.add(new ReminderEntity());
        }
        return reminderEntities;
    }

    private List<StatusEnum> statusEnumList() {
        return Arrays.asList(StatusEnum.DONE, StatusEnum.NOT_DONE);
    }

}