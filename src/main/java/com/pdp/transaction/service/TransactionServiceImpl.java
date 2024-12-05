package com.pdp.transaction.service;

import com.pdp.transaction.api.request.TransactionsRequest;
import com.pdp.transaction.api.response.TransactionsResponse;
import com.pdp.transaction.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionMapper transactionMapper;

    @Override
    public Mono<TransactionsResponse> transactions(TransactionsRequest request) {
        var entity = transactionMapper.toEntity(request);
        log.info("Transaction Entity created: {}", entity);

        return Mono.just(new TransactionsResponse("Transaction processed successfully"));
    }
}
