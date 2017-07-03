package com.walmart.reminder.rest;

import com.walmart.reminder.dao.StatusRepository;
import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.entity.StatusEntity;
import com.walmart.reminder.service.ReminderService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by HiepNguyen on 7/2/2017.
 */

@Path("/reminders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReminderRestImpl implements ReminderRest{

    @Inject
    private ReminderService reminderService;

    @Override
    public Response getReminders() {
        return Response.ok(reminderService.getReminders()).build();
    }

    @Override
    public Response getReminderById(Long reminderId) {
        return Response.ok(reminderService.getReminderById(reminderId)).build();
    }

    @Override
    public Response updateReminder(ReminderDto reminder) {
        reminderService.updateReminder(reminder);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Response postReminder(ReminderDto reminder) {
        return Response.ok(reminderService.addReminder(reminder)).build();
    }
}
