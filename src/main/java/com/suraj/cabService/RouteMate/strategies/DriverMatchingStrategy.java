package com.suraj.cabService.RouteMate.strategies;

import com.suraj.cabService.RouteMate.entities.Driver;
import com.suraj.cabService.RouteMate.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
