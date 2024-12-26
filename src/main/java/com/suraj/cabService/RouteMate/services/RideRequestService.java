package com.suraj.cabService.RouteMate.services;

import com.suraj.cabService.RouteMate.entities.RideRequest;

public interface RideRequestService {
    RideRequest findRideRequestById(Long rideRequestId);
    void update(RideRequest rideRequest);
}
