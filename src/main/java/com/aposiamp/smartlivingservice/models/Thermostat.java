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
@Table(name = "Thermostats")
@AllArgsConstructor
@NoArgsConstructor
public class Thermostat extends Device {
    @NotNull
    @Min(value = 10)
    @Max(value = 30)
    private Integer temperature;
}
