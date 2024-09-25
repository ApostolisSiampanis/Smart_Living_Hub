package com.aposiamp.smartlivingservice.services;

import com.aposiamp.smartlivingservice.dto.TemperatureDto;
import com.aposiamp.smartlivingservice.models.Thermostat;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ThermostatService {

    @Inject
    DeviceService deviceService;

    @Transactional
    public void updateTemperature(String id, TemperatureDto temperatureDto) {
        Thermostat thermostat = Thermostat.findById(id);
        thermostat.setTemperature(temperatureDto.getTemperature());

        deviceService.update(thermostat);
    }
}
