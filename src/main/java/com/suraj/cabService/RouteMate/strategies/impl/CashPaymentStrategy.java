package com.suraj.cabService.RouteMate.strategies.impl;

import com.suraj.cabService.RouteMate.entities.Driver;
import com.suraj.cabService.RouteMate.entities.Payment;
import com.suraj.cabService.RouteMate.entities.enums.PaymentStatus;
import com.suraj.cabService.RouteMate.entities.enums.TransactionMethod;
import com.suraj.cabService.RouteMate.repositories.PaymentRepository;
import com.suraj.cabService.RouteMate.services.WalletService;
import com.suraj.cabService.RouteMate.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Rider -> 100
//Driver -> 70 and deduct Rs-30 from Driver's wallet
@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;
    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        double platformCommission = payment.getAmount();

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission, null,
                payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}


//Same startegy for rating-

//10 ratingsCount -> 4.0
//new rating 4.6
//updated rating
//new rating 44.6/11 -> 4.05