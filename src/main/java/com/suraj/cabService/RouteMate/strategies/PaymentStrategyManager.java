package com.suraj.cabService.RouteMate.strategies;

import com.suraj.cabService.RouteMate.entities.enums.PaymentMethod;
import com.suraj.cabService.RouteMate.strategies.impl.CashPaymentStrategy;
import com.suraj.cabService.RouteMate.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {
    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }
}
