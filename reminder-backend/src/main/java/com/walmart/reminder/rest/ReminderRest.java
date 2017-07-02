package com.walmart.reminder.rest;

import com.walmart.reminder.dto.ReminderDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by HiepNguyen on 7/2/2017.
 */

public interface ReminderRest {

    @GET
    Response getReminders();

    @GET
    @Path("/{id}")
    Response getReminderById(@PathParam("id") Long reminderId);

    @PUT
    @Path("{id}")
    Response updateReminder(@PathParam("id") Long id,  ReminderDto reminder);

    @POST
    Response postReminder(ReminderDto reminder);

}
