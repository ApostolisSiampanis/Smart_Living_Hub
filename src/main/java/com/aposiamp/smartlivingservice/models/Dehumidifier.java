package com.aposiamp.smartlivingservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "dehumidifiers")
@AllArgsConstructor
@NoArgsConstructor
public class Dehumidifier extends Device {
    @NotNull
    @Min(value = 40)
    @Max(value = 95)
    @Column(name = "humidity_level")
    private Integer humidityLevel;
    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    @Column(name = "fan_speed")
    private Integer fanSpeed;
}
