package com.walmart.reminder.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@Provider
public class IllegalArgumentExceptionMapper extends BaseExceptionMapper<IllegalArgumentException> {
    @Override
    public Response toResponse(IllegalArgumentException e) {
        return this.buildResponse(Response.Status.BAD_REQUEST, e.getMessage());
    }
}
