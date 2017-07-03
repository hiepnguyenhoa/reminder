package com.walmart.reminder.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
public abstract class BaseExceptionMapper<T extends Exception> implements ExceptionMapper<T> {

    protected Response buildResponse(Response.Status status, Object entity){
        return Response.status(status).entity(entity).build();
    }
}
