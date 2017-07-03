package com.walmart.reminder.exceptionmapper;

import com.walmart.reminder.exception.NotNullException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@Provider
public class NotNullExceptionMapper extends BaseExceptionMapper<NotNullException> {
    @Override
    public Response toResponse(NotNullException exp) {
        return buildResponse(Response.Status.BAD_REQUEST, exp.getMessage());
    }
}
