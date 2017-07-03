package com.walmart.reminder.exceptionmapper;

import com.walmart.reminder.exception.NullObjectException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@Provider
public class NullObjectExceptionMapper extends BaseExceptionMapper<NullObjectException> {
    @Override
    public Response toResponse(NullObjectException e) {
        return this.buildResponse(Response.Status.BAD_REQUEST, e);
    }
}
