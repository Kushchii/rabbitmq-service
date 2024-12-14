package com.pdp.mail.service.rabbitmq;

import com.pdp.mail.config.RabbitmqConfig;
import com.pdp.mail.service.rabbitmq.dto.TransactionPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendTransaction(UUID transactionId, TransactionPayload payload) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY, payload);
        log.info("Transaction message sent: {} with payload: {}", transactionId, payload);
    }
}
