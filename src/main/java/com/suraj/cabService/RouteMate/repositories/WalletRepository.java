package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.Payment;
import com.suraj.cabService.RouteMate.entities.Ride;
import com.suraj.cabService.RouteMate.entities.User;
import com.suraj.cabService.RouteMate.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUser(User user);
}
