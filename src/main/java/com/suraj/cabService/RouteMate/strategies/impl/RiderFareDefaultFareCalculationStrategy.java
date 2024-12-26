package com.suraj.cabService.RouteMate.strategies.impl;

import com.suraj.cabService.RouteMate.entities.RideRequest;
import com.suraj.cabService.RouteMate.services.DistanceService;
import com.suraj.cabService.RouteMate.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    @Override
    public double calculateFare(RideRequest rideRequest) {

        Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());

        return distance * RIDE_FARE_MULTIPLIER;
    }
}
