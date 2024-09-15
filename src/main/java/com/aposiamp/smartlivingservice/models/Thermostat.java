package com.aposiamp.smartlivingservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "thermostats")
@AllArgsConstructor
@NoArgsConstructor
public class Thermostat extends Device {
    private Integer temperature;
}
