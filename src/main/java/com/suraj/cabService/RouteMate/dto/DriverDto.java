package com.suraj.cabService.RouteMate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private Long id;
    private UserDto user;
    private Double rating;
    private Boolean available;
    private String vehicleId;
}
