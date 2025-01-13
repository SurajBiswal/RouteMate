package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {

}
