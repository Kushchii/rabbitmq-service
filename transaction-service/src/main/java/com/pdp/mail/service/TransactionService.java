package com.pdp.mail.service;

import com.pdp.mail.api.request.TransactionsRequest;
import com.pdp.mail.api.response.TransactionsResponse;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<TransactionsResponse> transactions(TransactionsRequest request);
}
