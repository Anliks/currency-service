package ru.max.processing.processingservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.max.processing.processingservice.model.AccountEvent;

@Service
public class AccountOperationEventListener {


    private final AccountEventSendingService sendingService;

    public AccountOperationEventListener(AccountEventSendingService sendingService) {
        this.sendingService = sendingService;
    }

    @TransactionalEventListener
    public void handlerEvent(AccountEvent evt) {
        sendingService.sendEvent(evt);
    }
}
