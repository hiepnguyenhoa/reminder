package com.walmart.reminder.exceptionmapper;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
@Provider
public class EntityNotFoundExceptionMapper extends BaseExceptionMapper<EntityNotFoundException> {
    @Override
    public Response toResponse(EntityNotFoundException e) {
        return this.buildResponse(Response.Status.BAD_REQUEST, e.getMessage());
    }
}
