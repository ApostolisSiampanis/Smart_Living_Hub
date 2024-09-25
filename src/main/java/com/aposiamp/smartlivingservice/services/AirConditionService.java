package com.aposiamp.smartlivingservice.services;

import com.aposiamp.smartlivingservice.dto.AirDirectionDto;
import com.aposiamp.smartlivingservice.dto.FanSpeedDto;
import com.aposiamp.smartlivingservice.dto.TemperatureDto;
import com.aposiamp.smartlivingservice.models.AirCondition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AirConditionService {

    @Inject
    DeviceService deviceService;

    @Transactional
    public void updateAirDirection(String id, AirDirectionDto airDirectionDto) {
        AirCondition airCondition = AirCondition.findById(id);
        airCondition.setAirDirection(airDirectionDto.getAirDirection());

        deviceService.update(airCondition);
    }

    @Transactional
    public void updateFanSpeed(String id, FanSpeedDto fanSpeedDto) {
        AirCondition airCondition = AirCondition.findById(id);
        airCondition.setFanSpeed(fanSpeedDto.getFanSpeed());

        deviceService.update(airCondition);
    }

    @Transactional
    public void updateTemperature(String id, TemperatureDto temperatureDto) {
        AirCondition airCondition = AirCondition.findById(id);
        airCondition.setTemperature(temperatureDto.getTemperature());

        deviceService.update(airCondition);
    }
}
