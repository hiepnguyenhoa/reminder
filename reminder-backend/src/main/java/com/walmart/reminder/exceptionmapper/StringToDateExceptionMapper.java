package com.walmart.reminder.exceptionmapper;

import com.walmart.reminder.exception.StringToDateException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@Provider
public class StringToDateExceptionMapper extends BaseExceptionMapper<StringToDateException> {
    @Override
    public Response toResponse(StringToDateException e) {
        return this.buildResponse(Response.Status.BAD_REQUEST, e.getMessage());
    }
}
