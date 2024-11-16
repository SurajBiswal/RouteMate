package com.suraj.cabService.RouteMate.strategies;

import com.suraj.cabService.RouteMate.dto.RideRequestDto;
import com.suraj.cabService.RouteMate.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
