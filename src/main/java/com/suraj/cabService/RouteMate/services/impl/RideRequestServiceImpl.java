package com.suraj.cabService.RouteMate.services.impl;

import com.suraj.cabService.RouteMate.entities.RideRequest;
import com.suraj.cabService.RouteMate.exceptions.ResourceNotFoundException;
import com.suraj.cabService.RouteMate.repositories.RideRequestRepository;
import com.suraj.cabService.RouteMate.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;
    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(()-> new ResourceNotFoundException("RideRequest not found with id: "+rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequest.getId()));
        rideRequestRepository.save(rideRequest);
    }
}
