package com.aposiamp.smartlivingservice.services;

import com.aposiamp.smartlivingservice.enums.DeviceMode;
import com.aposiamp.smartlivingservice.enums.DeviceState;
import com.aposiamp.smartlivingservice.enums.DeviceType;
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
    public void updateState(String id, String newStateString) throws IllegalArgumentException {

        DeviceState newState;
        try {
            newState = DeviceState.valueOf(newStateString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid DeviceState. Value: " + newStateString);
        }

        Device device = Device.findById(id);
        device.setState(newState);

        update(device);

    }

    @Transactional
    public void updateMode(String id, String newModeString) throws IllegalArgumentException {

        DeviceMode newMode;
        try {
            newMode = DeviceMode.valueOf(newModeString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid DeviceMode. Value: " + newModeString);
        }

        Device device = Device.findById(id);
        device.setMode(newMode);

        update(device);

    }

    private void update(Device device) throws IllegalArgumentException {
        Set<ConstraintViolation<Device>> violations = validator.validate(device);

        if (!violations.isEmpty()) {
            String errors = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining());

            throw new IllegalArgumentException(errors);
        }

        device.persist();
    }

}
