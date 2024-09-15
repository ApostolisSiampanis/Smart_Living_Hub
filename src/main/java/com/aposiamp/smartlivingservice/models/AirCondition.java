package com.aposiamp.smartlivingservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "airconditions")
@AllArgsConstructor
@NoArgsConstructor
public class AirCondition extends Device {
    @NotNull
    @Min(value = 0)
    @Max(value = 4)
    private Integer airDirection;
    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    private Integer fanSpeed;
    @NotNull
    @Min(value = 16)
    @Max(value = 30)
    private Integer temperature;
    @NotNull
    @Min(value = 0)
    @Max(value = 3500)
    private Integer powerConsumption;
}
