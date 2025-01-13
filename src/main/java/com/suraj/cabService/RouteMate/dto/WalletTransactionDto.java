package com.suraj.cabService.RouteMate.dto;

import com.suraj.cabService.RouteMate.entities.Ride;
import com.suraj.cabService.RouteMate.entities.Wallet;
import com.suraj.cabService.RouteMate.entities.enums.TransactionMethod;
import com.suraj.cabService.RouteMate.entities.enums.TransactionType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDto {
    private long id;

    private Double amount;

    private TransactionType transactionType;
    private TransactionMethod transactionMethod;

    private RideDto ride;

    private String transactionId;

    private WalletDto wallet;

    private LocalDateTime timeStamp;
}
