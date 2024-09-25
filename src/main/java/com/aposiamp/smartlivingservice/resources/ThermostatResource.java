package com.aposiamp.smartlivingservice.resources;

import com.aposiamp.smartlivingservice.dto.TemperatureDto;
import com.aposiamp.smartlivingservice.services.ThermostatService;
import jakarta.inject.Inject;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/thermostats")
@Produces(MediaType.APPLICATION_JSON)
public class ThermostatResource {

    @Inject
    ThermostatService thermostatService;

    @PATCH
    @Path("/{id}/temperature")
    public Response updateTemperature(@PathParam("id") String id, TemperatureDto temperatureDto) {
        thermostatService.updateTemperature(id, temperatureDto);
        return Response.noContent().build();
    }
}
