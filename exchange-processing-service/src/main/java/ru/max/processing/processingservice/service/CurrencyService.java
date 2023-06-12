package ru.max.processing.processingservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;



@Service
@AllArgsConstructor
public class CurrencyService {

    private final String URL_CURRENCY = "http://localhost:8085/currency/rate/";


    private RestTemplate restTemplate;


    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {
        BigDecimal oneCurs = new BigDecimal(1);

        var rateFrom = !fromCurrency.equals("RUB") ? restTemplate.getForEntity(URL_CURRENCY + fromCurrency, BigDecimal.class).getBody()
                : oneCurs;
        var rateTo = !toCurrency.equals("RUB") ? restTemplate.getForEntity(URL_CURRENCY + toCurrency, BigDecimal.class).getBody()
                : oneCurs;

        var currRateFrom = new BigDecimal(1).divide(rateFrom,6, RoundingMode.HALF_UP);
        var currRateTo = new BigDecimal(1).divide(rateTo,6, RoundingMode.HALF_UP);

        return currRateTo.divide(currRateFrom, 6, RoundingMode.HALF_UP);
    }
}