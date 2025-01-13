package com.suraj.cabService.RouteMate.services;

import com.suraj.cabService.RouteMate.entities.Ride;
import com.suraj.cabService.RouteMate.entities.User;
import com.suraj.cabService.RouteMate.entities.Wallet;
import com.suraj.cabService.RouteMate.entities.enums.TransactionMethod;

public interface WalletService {
    Wallet addMoneyToWallet(User user, Double amount,
                            String transactionId, Ride ride,
                            TransactionMethod transactionMethod);
    Wallet deductMoneyFromWallet(User user, Double amount,
                                 String transactionId, Ride ride,
                                 TransactionMethod transactionMethod);
    void withdrawAllMyMoneyFromWallet();
    Wallet findWalletById(Long walletId);
    Wallet createNewWallet(User user);
    Wallet findByUser(User user);
}
