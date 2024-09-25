package com.aposiamp.smartlivingservice.resources;

import com.aposiamp.smartlivingservice.enums.DeviceType;
import com.aposiamp.smartlivingservice.models.Device;
import com.aposiamp.smartlivingservice.services.DeviceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResource {

    @Inject
    DeviceService deviceService;

    @GET
    @Path("/{id}")
    public Response getDevice(@PathParam("id") String id) {
        Device device = Device.findById(id);

        if (device == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Return the device, which will be serialized according to its actual type
        return Response.ok(device).build();
    }

    @GET
    @Path("/id-and-type/{id}/{type}")
    public Response getDeviceByIdAndType(@PathParam("id") String id, @PathParam("type") DeviceType type) {

        Optional<Device> deviceOptional = deviceService.getDeviceByIdAndType(id, type);

        if (deviceOptional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(deviceOptional.get()).build();
    }

    @PATCH
    @Path("/{id}/state")
    public Response updateState(@PathParam("id") String id, String newStateString) {

        try {
            deviceService.updateState(id, newStateString);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/mode")
    public Response updateMode(@PathParam("id") String id, String newModeString) {

        try {
            deviceService.updateMode(id, newModeString);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        return Response.noContent().build();
    }
}
