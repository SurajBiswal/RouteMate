package com.suraj.cabService.RouteMate.dto;

import com.suraj.cabService.RouteMate.entities.enums.PaymentMethod;
import com.suraj.cabService.RouteMate.entities.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {
    private Long id;
    private PointDto pickupLocation;
    private PointDto dropOffLocation;
    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;
    private String otp;
    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
