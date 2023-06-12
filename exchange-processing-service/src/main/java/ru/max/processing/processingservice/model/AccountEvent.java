package ru.max.processing.processingservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
public class AccountEvent {

    @NonNull
    private String uuid;

    private Long userId, accountId;

    private Long fromAccount;

    @NonNull
    private String currency;

    @NonNull
    private Operation operation;

    @NonNull
    private BigDecimal amount;

    @NonNull
    private Date created;
}
