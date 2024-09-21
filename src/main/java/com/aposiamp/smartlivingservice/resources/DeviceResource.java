package com.aposiamp.smartlivingservice.resources;

import com.aposiamp.smartlivingservice.enums.DeviceType;
import com.aposiamp.smartlivingservice.models.Device;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResource {

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
        Device device = Device.<Device>listAll().stream()
                .filter(d -> d.getId().equals(id) && d.getType() == type)
                .findFirst()
                .orElse(null);

        if (device == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(device).build();
    }
}
