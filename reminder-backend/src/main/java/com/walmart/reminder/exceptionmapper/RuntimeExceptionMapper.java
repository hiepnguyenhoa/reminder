package com.walmart.reminder.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@Provider
public class RuntimeExceptionMapper extends BaseExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException e) {
        return this.buildResponse(Response.Status.INTERNAL_SERVER_ERROR, e.fillInStackTrace());
    }
}
