package com.suraj.cabService.RouteMate.services;

import com.suraj.cabService.RouteMate.dto.DriverDto;
import com.suraj.cabService.RouteMate.dto.RideDto;
import com.suraj.cabService.RouteMate.dto.RiderDto;
import com.suraj.cabService.RouteMate.entities.Driver;

import java.util.List;

public interface DriverService {
    RideDto acceptRide(Long rideRequestId);
    RideDto cancelRide(Long rideId);
    RideDto startRide(Long rideId, String otp);
    RideDto endRide(Long rideId);
    RiderDto rateRider(Long rideId, Integer rating);
    DriverDto getMyProfile();
    List<RideDto> getAllMyRides();
    Driver getCurrentDriver();
}
