package com.pdp.mail.service;

import com.pdp.mail.api.request.TransactionsRequest;
import com.pdp.mail.api.response.TransactionsResponse;
import com.pdp.mail.mapper.TransactionMapper;
import com.pdp.mail.persistent.repository.TransactionRepository;
import com.pdp.mail.service.rabbitmq.TransactionMessageProducer;
import com.pdp.mail.service.rabbitmq.dto.TransactionPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionMapper transactionMapper;

    private final TransactionMessageProducer transactionMessageProducer;

    private final TransactionRepository transactionRepository;

    private static final String TRANSACTION_SUCCESS = "SUCCESS";

    @Override
    public Mono<TransactionsResponse> transactions(TransactionsRequest request) {
        var entity = transactionMapper.toEntity(request);
        log.info("Transaction Entity created: {}", entity);

        return transactionRepository.save(entity)
                .doOnSuccess(savedEntity -> {
                    if (TRANSACTION_SUCCESS.equalsIgnoreCase(savedEntity.getStatus())) {
                        TransactionPayload payload = new TransactionPayload(
                                savedEntity.getTransactionId(),
                                savedEntity.getStatus(),
                                savedEntity.getUserId()
                        );
                        transactionMessageProducer.sendTransaction(savedEntity.getTransactionId(), payload);
                    }
                })
                .thenReturn(new TransactionsResponse("Transaction processed successfully"));
    }
}
