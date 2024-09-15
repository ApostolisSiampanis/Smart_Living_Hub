package com.aposiamp.smartlivingservice.models;

import com.aposiamp.smartlivingservice.enums.DeviceMode;
import com.aposiamp.smartlivingservice.enums.DeviceState;
import com.aposiamp.smartlivingservice.enums.DeviceType;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Device extends PanacheEntityBase {

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private DeviceType type;
    @Enumerated(EnumType.STRING)
    private DeviceState state;
    @Enumerated(EnumType.STRING)
    private DeviceMode mode;
}
