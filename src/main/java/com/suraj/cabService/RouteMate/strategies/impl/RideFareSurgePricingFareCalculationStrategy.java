package com.suraj.cabService.RouteMate.strategies.impl;

import com.suraj.cabService.RouteMate.entities.RideRequest;
import com.suraj.cabService.RouteMate.services.DistanceService;
import com.suraj.cabService.RouteMate.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;
    @Override
    public double calculateFare(RideRequest rideRequest) {

        Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());

        return distance * RIDE_FARE_MULTIPLIER * SURGE_FACTOR;
    }
}
