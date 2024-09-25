package com.aposiamp.smartlivingservice.services;

import com.aposiamp.smartlivingservice.dto.DeviceModeDto;
import com.aposiamp.smartlivingservice.dto.DeviceStateDto;
import com.aposiamp.smartlivingservice.enums.DeviceMode;
import com.aposiamp.smartlivingservice.enums.DeviceState;
import com.aposiamp.smartlivingservice.enums.DeviceType;
import com.aposiamp.smartlivingservice.exceptions.FieldValidationException;
import com.aposiamp.smartlivingservice.models.Device;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class DeviceService {

    @Inject
    Validator validator;

    public Optional<Device> getDeviceByIdAndType(String id, DeviceType type) {
        return Device.<Device>listAll().stream()
                .filter(d -> d.getId().equals(id) && d.getType() == type)
                .findFirst();
    }

    @Transactional
    public void updateState(String id, DeviceStateDto deviceStateDto) {

        DeviceState newState;
        try {
            newState = DeviceState.valueOf(deviceStateDto.getDeviceState());
        } catch (IllegalArgumentException e) {
            throw new FieldValidationException("Invalid DeviceState. Value: " + deviceStateDto.getDeviceState());
        }

        Device device = Device.findById(id);
        device.setState(newState);

        update(device);

    }

    @Transactional
    public void updateMode(String id, DeviceModeDto deviceModeDto) {

        DeviceMode newMode;
        try {
            newMode = DeviceMode.valueOf(deviceModeDto.getDeviceMode());
        } catch (IllegalArgumentException e) {
            throw new FieldValidationException("Invalid DeviceMode. Value: " + deviceModeDto.getDeviceMode());
        }

        Device device = Device.findById(id);
        device.setMode(newMode);

        update(device);

    }

    public void update(Device device) {
        Set<ConstraintViolation<Device>> violations = validator.validate(device);

        if (!violations.isEmpty()) {
            String errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
            throw new FieldValidationException(errors);
        }

        device.persist();
    }

}
