package com.aposiamp.smartlivingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class DeviceHistoryDto {
    private String deviceId;
    private Instant startTime;
    private Instant endTime;
    private double powerConsumption;
}
