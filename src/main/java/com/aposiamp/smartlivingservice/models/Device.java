package com.aposiamp.smartlivingservice.models;

import com.aposiamp.smartlivingservice.enums.DeviceMode;
import com.aposiamp.smartlivingservice.enums.DeviceState;
import com.aposiamp.smartlivingservice.enums.DeviceType;
import com.aposiamp.smartlivingservice.validation.ValidDeviceMode;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Devices")
@ValidDeviceMode
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Device extends PanacheEntityBase {

    @Id
    private String id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private DeviceType type;
    @NotNull
    @Enumerated(EnumType.STRING)
    private DeviceState state;
    @NotNull
    @Enumerated(EnumType.STRING)
    private DeviceMode mode;
}
