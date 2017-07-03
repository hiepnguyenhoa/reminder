package com.walmart.reminder.exceptionmapper;

import com.walmart.reminder.exception.EmptyException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@Provider
public class EmptyExceptionMapper extends BaseExceptionMapper<EmptyException> {
    @Override
    public Response toResponse(EmptyException e) {
        return this.buildResponse(Response.Status.BAD_REQUEST, e.getCause());
    }
}
