package com.suraj.cabService.RouteMate.strategies;

import com.suraj.cabService.RouteMate.entities.Payment;

public interface PaymentStrategy {
    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);
}
