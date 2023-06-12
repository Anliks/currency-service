package ru.max.processing.processingservice.dto;


import lombok.Data;
import ru.max.processing.processingservice.model.Operation;

import java.math.BigDecimal;

@Data
public class PutAccountMoneyDTO {
    private String uid;
    private BigDecimal money;
    private Operation operation;
}
