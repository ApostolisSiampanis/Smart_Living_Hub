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
@Table(name = "Dehumidifiers")
@AllArgsConstructor
@NoArgsConstructor
public class Dehumidifier extends Device {
    @NotNull
    @Min(value = 40)
    @Max(value = 95)
    private Integer humidityLevel;
    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    private Integer fanSpeed;
}
