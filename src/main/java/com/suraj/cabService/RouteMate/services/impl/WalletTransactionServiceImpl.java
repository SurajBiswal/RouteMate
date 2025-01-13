package com.suraj.cabService.RouteMate.services.impl;

import com.suraj.cabService.RouteMate.dto.WalletTransactionDto;
import com.suraj.cabService.RouteMate.entities.WalletTransaction;
import com.suraj.cabService.RouteMate.repositories.WalletTransactionRepository;
import com.suraj.cabService.RouteMate.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
    }
}
