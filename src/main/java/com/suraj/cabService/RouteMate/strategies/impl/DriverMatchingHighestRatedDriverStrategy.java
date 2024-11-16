package com.suraj.cabService.RouteMate.strategies.impl;

import com.suraj.cabService.RouteMate.dto.RideRequestDto;
import com.suraj.cabService.RouteMate.entities.Driver;
import com.suraj.cabService.RouteMate.strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
