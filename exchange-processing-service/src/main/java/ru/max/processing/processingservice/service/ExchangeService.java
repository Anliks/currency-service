package ru.max.processing.processingservice.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.max.processing.processingservice.model.AccountEntity;
import ru.max.processing.processingservice.repository.AccountRepository;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ExchangeService {

    private final AccountService accountService;

    private final AccountRepository accountRepository;

    private final CurrencyService currencyService;


    public BigDecimal exchangeCurrency(String uid, Long fromAccountId, Long toAccountId, BigDecimal money){

        //получаем счет отправителя и получателя
        AccountEntity accFrom = accountService.getAccountById(fromAccountId);
        AccountEntity accTo = accountService.getAccountById(toAccountId);


        if(accFrom.getCurrencyCode().equals(accTo.getCurrencyCode())) {
            accFrom.setBalance(accFrom.getBalance().subtract(money));
            accTo.setBalance(accTo.getBalance().add(money));
            accountRepository.save(accFrom);
            accountRepository.save(accTo);
            return accTo.getBalance();
        }

        var exchangeRate = currencyService.getExchangeRate(accFrom.getCurrencyCode(), accTo.getCurrencyCode());
        accFrom.setBalance(accFrom.getBalance().subtract(money));
        accTo.setBalance(accTo.getBalance().add(money.multiply(exchangeRate)));
        accountRepository.save(accFrom);
        accountRepository.save(accTo);
        return exchangeRate;
    }

}
