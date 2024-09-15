package com.aposiamp.smartlivingservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "dehumidifiers")
@AllArgsConstructor
@NoArgsConstructor
public class Dehumidifier extends Device {
    private Integer humidityLevel;
    private Integer fanSpeed;
    private Integer powerConsumption;
}
