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
@Table(name = "air_conditions")
@AllArgsConstructor
@NoArgsConstructor
public class AirCondition extends Device {
    @NotNull
    @Min(value = 0)
    @Max(value = 4)
    @Column(name = "air_direction")
    private Integer airDirection;
    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    @Column(name = "fan_speed")
    private Integer fanSpeed;
    @NotNull
    @Min(value = 16)
    @Max(value = 30)
    private Integer temperature;
}
