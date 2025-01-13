package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.Payment;
import com.suraj.cabService.RouteMate.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);
}
