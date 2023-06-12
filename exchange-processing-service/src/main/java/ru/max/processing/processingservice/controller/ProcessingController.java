package ru.max.processing.processingservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.max.processing.processingservice.dto.ExchangeMoneyDTO;
import ru.max.processing.processingservice.dto.NewAccountDTO;
import ru.max.processing.processingservice.model.AccountEntity;
import ru.max.processing.processingservice.dto.PutAccountMoneyDTO;
import ru.max.processing.processingservice.model.Operation;
import ru.max.processing.processingservice.service.AccountService;
import ru.max.processing.processingservice.service.ExchangeService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("processing")
@RequiredArgsConstructor
public class ProcessingController {

    private final AccountService accountService;

    private final ExchangeService exchangeService;

    @PostMapping("/account")
    public AccountEntity createAccount(@RequestBody NewAccountDTO account) {
        return accountService.createNewAccount(account);
    }
   @PutMapping("/account/{id}")
    public AccountEntity putMoney(@PathVariable("id")Long accountId,@RequestBody PutAccountMoneyDTO data) {
        Operation operation = Operation.PUT;
        Long targetAccount = accountId;
        return accountService.addMoneyToAccount(data.getUid(), accountId, targetAccount, operation, data.getMoney());
   }
   @PutMapping("/exchange")
    public BigDecimal exchange(@RequestBody ExchangeMoneyDTO data) {
        String uuid = "";
       return exchangeService.exchangeCurrency(uuid, data.getFromAccountId(), data.getToAccountId(), data.getMoney());
   }

   @GetMapping("/accounts")
    public List<AccountEntity> getAllAccount() {
        return accountService.getAllAccount();

   }

}
