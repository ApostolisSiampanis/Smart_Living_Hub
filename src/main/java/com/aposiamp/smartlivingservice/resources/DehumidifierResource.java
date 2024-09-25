package com.aposiamp.smartlivingservice.resources;

import com.aposiamp.smartlivingservice.dto.FanSpeedDto;
import com.aposiamp.smartlivingservice.dto.HumidityLevelDto;
import com.aposiamp.smartlivingservice.services.DehumidifierService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/dehumidifiers")
@Produces(MediaType.APPLICATION_JSON)
public class DehumidifierResource {

    @Inject
    DehumidifierService dehumidifierService;

    @PATCH
    @Path("/{id}/humidity-level")
    public Response updateHumidityLevel(@PathParam("id") String id, HumidityLevelDto humidityLevelDto) {
        dehumidifierService.updateHumidityLevel(id, humidityLevelDto);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/fan-speed")
    public Response updateFanSpeed(@PathParam("id") String id, FanSpeedDto fanSpeedDto) {
        dehumidifierService.updateFanSpeed(id, fanSpeedDto);
        return Response.noContent().build();
    }
}
