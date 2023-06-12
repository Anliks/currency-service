package ru.max.processing.processingservice.dto;


import lombok.Data;

@Data
public class NewAccountDTO {

    private String currencyCode;
    private Long userId;
}
