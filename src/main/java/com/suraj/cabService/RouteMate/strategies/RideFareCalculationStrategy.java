package com.suraj.cabService.RouteMate.strategies;

import com.suraj.cabService.RouteMate.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;
    double calculateFare(RideRequest rideRequest);
}
