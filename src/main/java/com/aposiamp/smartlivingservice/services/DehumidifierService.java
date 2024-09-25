package com.aposiamp.smartlivingservice.services;

import com.aposiamp.smartlivingservice.dto.FanSpeedDto;
import com.aposiamp.smartlivingservice.dto.HumidityLevelDto;
import com.aposiamp.smartlivingservice.models.Dehumidifier;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DehumidifierService {

    @Inject
    DeviceService deviceService;

    @Transactional
    public void updateHumidityLevel(String id, HumidityLevelDto humidityLevelDto) {
        Dehumidifier dehumidifier = Dehumidifier.findById(id);
        dehumidifier.setHumidityLevel(humidityLevelDto.getHumidityLevel());
        deviceService.update(dehumidifier);
    }

    @Transactional
    public void updateFanSpeed(String id, FanSpeedDto fanSpeedDto) {
        Dehumidifier dehumidifier = Dehumidifier.findById(id);
        dehumidifier.setFanSpeed(fanSpeedDto.getFanSpeed());
        deviceService.update(dehumidifier);
    }

}
