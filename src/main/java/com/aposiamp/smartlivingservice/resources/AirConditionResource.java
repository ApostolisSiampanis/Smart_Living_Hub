package com.aposiamp.smartlivingservice.resources;

import com.aposiamp.smartlivingservice.dto.AirDirectionDto;
import com.aposiamp.smartlivingservice.dto.FanSpeedDto;
import com.aposiamp.smartlivingservice.dto.TemperatureDto;
import com.aposiamp.smartlivingservice.services.AirConditionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/air-conditions")
@Produces(MediaType.APPLICATION_JSON)
public class AirConditionResource {

    @Inject
    AirConditionService airConditionService;

    @PATCH
    @Path("/{id}/air-direction")
    public Response updateAirDirection(@PathParam("id") String id, AirDirectionDto airDirectionDto) {
        airConditionService.updateAirDirection(id, airDirectionDto);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/fan-speed")
    public Response updateFanSpeed(@PathParam("id") String id, FanSpeedDto fanSpeedDto) {
        airConditionService.updateFanSpeed(id, fanSpeedDto);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/temperature")
    public Response updateTemperature(@PathParam("id") String id, TemperatureDto temperatureDto) {
        airConditionService.updateTemperature(id, temperatureDto);
        return Response.noContent().build();
    }
}
