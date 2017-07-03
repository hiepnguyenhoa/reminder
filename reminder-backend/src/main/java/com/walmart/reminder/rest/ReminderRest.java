package com.walmart.reminder.rest;

import com.walmart.reminder.dto.ReminderDto;
import com.walmart.reminder.dto.StatusEnum;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by HiepNguyen on 7/2/2017.
 */

public interface ReminderRest {

    @GET
    Response getReminders(@QueryParam("status") List<StatusEnum> status,
                          @QueryParam("start") String sDate,
                          @QueryParam("end") String eDate);

    @GET
    @Path("/{id}")
    Response getReminderById(@PathParam("id") Long reminderId);

    @PUT
    Response updateReminder(ReminderDto reminder);

    @POST
    Response postReminder(ReminderDto reminder);

}
