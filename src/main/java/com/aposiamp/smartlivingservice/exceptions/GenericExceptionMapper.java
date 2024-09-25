package com.aposiamp.smartlivingservice.exceptions;

import com.aposiamp.smartlivingservice.dto.ErrorResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<FieldValidationException> {

    @Override
    public Response toResponse(FieldValidationException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse("Field Validation Error", e.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
