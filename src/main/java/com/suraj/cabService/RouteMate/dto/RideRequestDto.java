package com.suraj.cabService.RouteMate.dto;

import com.suraj.cabService.RouteMate.entities.enums.PaymentMethod;
import com.suraj.cabService.RouteMate.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {
    private Long id;
    private PointDto pickupLocation;
    private PointDto dropOffLocation;
    private LocalDateTime requestedTime;
    private RiderDto rider;
    private Double fare;
    private PaymentMethod paymentMethod;
    private RideRequestStatus rideRequestStatus;
}
