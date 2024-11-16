package com.suraj.cabService.RouteMate.strategies;

import com.suraj.cabService.RouteMate.dto.RideRequestDto;

public interface RideFareCalculationStrategy {
    double calculateFare(RideRequestDto rideRequestDto);
}
