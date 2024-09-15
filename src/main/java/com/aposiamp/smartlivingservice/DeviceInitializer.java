package com.aposiamp.smartlivingservice;

import com.aposiamp.smartlivingservice.enums.DeviceMode;
import com.aposiamp.smartlivingservice.enums.DeviceState;
import com.aposiamp.smartlivingservice.enums.DeviceType;
import com.aposiamp.smartlivingservice.models.AirCondition;
import com.aposiamp.smartlivingservice.models.Dehumidifier;
import com.aposiamp.smartlivingservice.models.Thermostat;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

@ApplicationScoped
public class DeviceInitializer {

    private static final Logger LOG = Logger.getLogger(DeviceInitializer.class);

    @Transactional
    public void init(@Observes StartupEvent ev) {
        LOG.info("Initializing devices...");

        // Check if devices already exist before inserting
        if (AirCondition.count() == 0) {
            AirCondition ac1 = new AirCondition();
            ac1.setId("AC-5267");
            ac1.setType(DeviceType.AIR_CONDITIONER);
            ac1.setState(DeviceState.ON);
            ac1.setMode(DeviceMode.HEAT);
            ac1.setAirDirection(1);
            ac1.setFanSpeed(2);
            ac1.setTemperature(25);
            ac1.setPowerConsumption(1000);

            // Save to db
            ac1.persist();
        }

        if (Thermostat.count() == 0) {
            Thermostat t1 = new Thermostat();
            t1.setId("TH-1234");
            t1.setType(DeviceType.THERMOSTAT);
            t1.setState(DeviceState.OFF);
            t1.setMode(DeviceMode.COOL);
            t1.setTemperature(20);

            t1.persist();
        }

        if (Dehumidifier.count() == 0) {
            Dehumidifier d1 = new Dehumidifier();
            d1.setId("DEH-8721");
            d1.setType(DeviceType.DEHUMIDIFIER);
            d1.setState(DeviceState.OFF);
            d1.setMode(DeviceMode.SILENT);
            d1.setHumidityLevel(50);
            d1.setFanSpeed(3);
            d1.setPowerConsumption(300);

            d1.persist();
        }
    }

}
