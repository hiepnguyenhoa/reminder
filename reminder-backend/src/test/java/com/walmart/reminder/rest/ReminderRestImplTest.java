package com.walmart.reminder.rest;

import com.walmart.reminder.converter.DateConverter;
import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.dto.StatusEnum;
import com.walmart.reminder.exception.NotNullException;
import com.walmart.reminder.exception.NullObjectException;
import com.walmart.reminder.service.ReminderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ReminderRestImplTest {

    @InjectMocks
    private ReminderRestImpl reminderRest;

    @Mock
    private ReminderService reminderService;

    //TODO change to Spy object when Mockito stable version supports default methods.
    @Mock
    private DateConverter dateConverter;

    @Test
    public void getReminders(){
        List<ReminderDto> reminderDtoList = new ArrayList<>();
        when(reminderService.getReminders(anyList(), any(Date.class), any(Date.class))).thenReturn(reminderDtoList);
        Response response = reminderRest.getReminders(Arrays.asList(StatusEnum.NOT_DONE, StatusEnum.DONE), new Date().toString(), new Date().toString());
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(reminderDtoList, response.getEntity());
        verify(reminderService, times(1)).getReminders(anyList(), any(Date.class), any(Date.class));
    }

    @Test
    public void getReminderById(){
        ReminderDto reminderDto = new ReminderDto();
        when(reminderService.getReminderById(anyLong())).thenReturn(reminderDto);
        Response response = reminderRest.getReminderById(1L);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(reminderDto, response.getEntity());
        verify(reminderService, times(1)).getReminderById(anyLong());
    }

    @Test(expected = EntityNotFoundException.class)
    public void getReminderById_EntityNotFoundException(){
        when(reminderService.getReminderById(anyLong())).thenThrow(new EntityNotFoundException());
        Response response = reminderRest.getReminderById(1L);
    }

    @Test(expected = NullObjectException.class)
    public void getReminderById_NullObjectException(){
        Response response = reminderRest.getReminderById(null);
    }

    @Test
    public void updateReminder(){
        ReminderDto reminderDto = new ReminderDto();
        reminderDto.setId(1L);
        Response response = reminderRest.updateReminder(reminderDto);
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    @Test(expected = NullObjectException.class)
    public void updateReminder_NullReminderDtoObject(){
        Response response = reminderRest.updateReminder(null);
    }

    @Test(expected = NullObjectException.class)
    public void updateReminder_NullIdValue(){
        Response response = reminderRest.updateReminder(new ReminderDto());
    }

    @Test
    public void postReminder(){
        ReminderDto reminderDto = new ReminderDto();
        when(reminderService.addReminder(any(ReminderDto.class))).thenReturn(reminderDto);
        Response response = reminderRest.postReminder(reminderDto);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(reminderDto, response.getEntity());
        verify(reminderService, times(1)).addReminder(any(ReminderDto.class));
    }

    @Test(expected = NullObjectException.class)
    public void postReminder_NullReminderObject(){
        Response response = reminderRest.postReminder(null);
    }

    @Test(expected = NotNullException.class)
    public void postReminder_NotNullIdValue(){
        ReminderDto reminderDto = new ReminderDto();
        reminderDto.setId(1L);
        Response response = reminderRest.postReminder(reminderDto);
    }

}