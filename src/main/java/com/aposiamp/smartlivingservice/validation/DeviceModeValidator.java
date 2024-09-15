package com.aposiamp.smartlivingservice.validation;

import com.aposiamp.smartlivingservice.enums.DeviceMode;
import com.aposiamp.smartlivingservice.enums.DeviceType;
import com.aposiamp.smartlivingservice.models.Device;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DeviceModeValidator implements ConstraintValidator<ValidDeviceMode, Device> {

    @Override
    public void initialize(ValidDeviceMode constraintAnnotation) {
    }

    @Override
    public boolean isValid(Device device, ConstraintValidatorContext context) {
        if (device == null) {
            return true;
        }

        DeviceType type = device.getType();
        DeviceMode mode = device.getMode();

        if (type == null || mode == null) {
            return true;
        }

        return switch (type) {
            case AIR_CONDITIONER ->
                    mode == DeviceMode.AUTO || mode == DeviceMode.COOL || mode == DeviceMode.HEAT || mode == DeviceMode.DRY;
            case THERMOSTAT -> mode == DeviceMode.AUTO || mode == DeviceMode.COOL || mode == DeviceMode.HEAT;
            case DEHUMIDIFIER ->
                    mode == DeviceMode.AUTO || mode == DeviceMode.HUMIDITY || mode == DeviceMode.DRY || mode == DeviceMode.SILENT;
        };
    }
}
