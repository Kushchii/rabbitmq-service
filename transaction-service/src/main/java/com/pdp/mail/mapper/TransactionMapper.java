package com.pdp.mail.mapper;

import com.pdp.mail.api.request.TransactionsRequest;
import com.pdp.mail.persistent.postgres.entity.TransactionsEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionsEntity toEntity(TransactionsRequest request) {
        var transaction = new TransactionsEntity();
        transaction.setId(request.getId());
        transaction.setAmount(request.getAmount());
        transaction.setUserId(request.getUserId());
        transaction.setCurrency(request.getCurrency());
        transaction.setStatus(request.getStatus());
        transaction.setDescription(request.getDescription());

        return transaction;
    }
}
