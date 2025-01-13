package com.suraj.cabService.RouteMate.strategies.impl;

import com.suraj.cabService.RouteMate.entities.Driver;
import com.suraj.cabService.RouteMate.entities.Payment;
import com.suraj.cabService.RouteMate.entities.Rider;
import com.suraj.cabService.RouteMate.entities.enums.PaymentStatus;
import com.suraj.cabService.RouteMate.entities.enums.TransactionMethod;
import com.suraj.cabService.RouteMate.repositories.PaymentRepository;
import com.suraj.cabService.RouteMate.services.WalletService;
import com.suraj.cabService.RouteMate.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),
                payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),
                driversCut, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
