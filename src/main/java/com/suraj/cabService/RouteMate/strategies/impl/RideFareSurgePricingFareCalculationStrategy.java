package com.suraj.cabService.RouteMate.strategies.impl;

import com.suraj.cabService.RouteMate.dto.RideRequestDto;
import com.suraj.cabService.RouteMate.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
