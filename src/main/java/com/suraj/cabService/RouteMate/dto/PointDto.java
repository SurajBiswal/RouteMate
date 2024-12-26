package com.suraj.cabService.RouteMate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDto {
    private double[] coordinates;
    private String type = "Points";
    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
