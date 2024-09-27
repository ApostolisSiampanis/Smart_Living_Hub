package com.aposiamp.smartlivingservice.resources;

import com.aposiamp.smartlivingservice.dto.DeviceHistoryDto;
import com.aposiamp.smartlivingservice.dto.DeviceModeDto;
import com.aposiamp.smartlivingservice.dto.DeviceStateDto;
import com.aposiamp.smartlivingservice.enums.DeviceState;
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
    public Response updateState(@PathParam("id") String id, DeviceStateDto deviceStateDto) {
        Device updatedDevice = deviceService.updateState(id, deviceStateDto);

        Response response;
        if (updatedDevice.getState() == DeviceState.OFF && updatedDevice.getTurnedOnAt() != null) {
            DeviceHistoryDto deviceHistoryDto = deviceService.calculatePowerConsumption(updatedDevice.getId());
            response = Response.ok(deviceHistoryDto).build();
        } else {
            response = Response.noContent().build();
        }

        return response;
    }

    @PATCH
    @Path("/{id}/mode")
    public Response updateMode(@PathParam("id") String id, DeviceModeDto deviceModeDto) {
        deviceService.updateMode(id, deviceModeDto);
        return Response.noContent().build();
    }
}
