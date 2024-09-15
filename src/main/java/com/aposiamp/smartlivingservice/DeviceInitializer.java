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

            ac1.persist();

            AirCondition ac2 = new AirCondition();
            ac2.setId("AC-6378");
            ac2.setType(DeviceType.AIR_CONDITIONER);
            ac2.setState(DeviceState.OFF);
            ac2.setMode(DeviceMode.COOL);
            ac2.setAirDirection(3);
            ac2.setFanSpeed(4);
            ac2.setTemperature(20);
            ac2.setPowerConsumption(1500);

            ac2.persist();


            AirCondition ac3 = new AirCondition();
            ac3.setId("AC-7489");
            ac3.setType(DeviceType.AIR_CONDITIONER);
            ac3.setState(DeviceState.ON);
            ac3.setMode(DeviceMode.DRY);
            ac3.setAirDirection(2);
            ac3.setFanSpeed(3);
            ac3.setTemperature(22);
            ac3.setPowerConsumption(1200);

            ac3.persist();

            AirCondition ac4 = new AirCondition();
            ac4.setId("AC-8590");
            ac4.setType(DeviceType.AIR_CONDITIONER);
            ac4.setState(DeviceState.OFF);
            ac4.setMode(DeviceMode.AUTO);
            ac4.setAirDirection(0);
            ac4.setFanSpeed(1);
            ac4.setTemperature(18);
            ac4.setPowerConsumption(2000);

            ac4.persist();
        }

        if (Thermostat.count() == 0) {
            Thermostat t1 = new Thermostat();
            t1.setId("TH-1234");
            t1.setType(DeviceType.THERMOSTAT);
            t1.setState(DeviceState.OFF);
            t1.setMode(DeviceMode.COOL);
            t1.setTemperature(20);

            t1.persist();

            Thermostat t2 = new Thermostat();
            t2.setId("TH-2345");
            t2.setType(DeviceType.THERMOSTAT);
            t2.setState(DeviceState.ON);
            t2.setMode(DeviceMode.HEAT);
            t2.setTemperature(25);

            t2.persist();

            Thermostat t3 = new Thermostat();
            t3.setId("TH-3456");
            t3.setType(DeviceType.THERMOSTAT);
            t3.setState(DeviceState.OFF);
            t3.setMode(DeviceMode.AUTO);
            t3.setTemperature(22);

            t3.persist();
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

            Dehumidifier d2 = new Dehumidifier();
            d2.setId("DEH-9832");
            d2.setType(DeviceType.DEHUMIDIFIER);
            d2.setState(DeviceState.ON);
            d2.setMode(DeviceMode.AUTO);
            d2.setHumidityLevel(60);
            d2.setFanSpeed(4);
            d2.setPowerConsumption(350);

            d2.persist();

            Dehumidifier d3 = new Dehumidifier();
            d3.setId("DEH-0943");
            d3.setType(DeviceType.DEHUMIDIFIER);
            d3.setState(DeviceState.OFF);
            d3.setMode(DeviceMode.DRY);
            d3.setHumidityLevel(55);
            d3.setFanSpeed(2);
            d3.setPowerConsumption(320);

            d3.persist();

            Dehumidifier d4 = new Dehumidifier();
            d4.setId("DEH-1054");
            d4.setType(DeviceType.DEHUMIDIFIER);
            d4.setState(DeviceState.ON);
            d4.setMode(DeviceMode.HUMIDITY);
            d4.setHumidityLevel(70);
            d4.setFanSpeed(0);
            d4.setPowerConsumption(400);

            d4.persist();
        }
    }

}
