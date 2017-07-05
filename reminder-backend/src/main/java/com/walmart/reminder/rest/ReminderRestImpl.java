package com.walmart.reminder.rest;

import com.walmart.reminder.converter.DateConverter;
import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.dto.StatusEnum;
import com.walmart.reminder.service.ReminderService;
import com.walmart.reminder.utils.ValidateUtils;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by HiepNguyen on 7/2/2017.
 */

@Path("/reminders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReminderRestImpl implements ReminderRest {

    private static final List<StatusEnum> STATUS = Arrays.asList(StatusEnum.DONE, StatusEnum.NOT_DONE);
    private static final Date MAX_DATE = new Date(Long.MAX_VALUE);
    private static final Date MIN_DATE = new Date(0);

    @Inject
    private ReminderService reminderService;

    @Inject
    private DateConverter dateConverter;

    @Override
    public Response getReminders(List<StatusEnum> status, String sDate, String eDate) {
        Date startDate = sDate == null ? MIN_DATE : dateConverter.toDate(sDate);
        Date endDate = eDate == null ? MAX_DATE : dateConverter.toDate(eDate);
        List<StatusEnum> statusEnums = status == null || status.size() == 0 ? STATUS : status;
        List<ReminderDto> list = reminderService.getReminders(statusEnums, startDate, endDate);
        GenericEntity entity = new GenericEntity<List<ReminderDto>>(list){};
        return Response.ok(entity).build();
    }

    @Override
    public Response getReminderById(Long reminderId) {
        ValidateUtils.validateNotNull(reminderId);
        return Response.ok(reminderService.getReminderById(reminderId)).build();
    }

    @Override
    public Response updateReminder(ReminderDto reminder) {
        ValidateUtils.validateNotNull(reminder);
        ValidateUtils.validateNotNull(reminder.getId());
        reminderService.updateReminder(reminder);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Response postReminder(ReminderDto reminder) {
        ValidateUtils.validateNotNull(reminder);
        ValidateUtils.validateNull(reminder.getId());
        return Response.ok(reminderService.addReminder(reminder)).build();
    }

    private <E> E defaultValue(E e, E defaultValue) {
        return e == null ? defaultValue : e;
    }
}
