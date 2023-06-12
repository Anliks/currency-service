package ru.max.processing.processingservice.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeMoneyDTO {

    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal money;
}
