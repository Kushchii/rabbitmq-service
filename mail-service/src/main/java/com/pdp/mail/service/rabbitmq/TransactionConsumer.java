package com.pdp.mail.service.rabbitmq;


import com.pdp.mail.config.RabbitmqConfig;
import com.pdp.mail.service.SenderService;
import com.pdp.mail.service.rabbitmq.dto.TransactionPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionConsumer {

    private final SenderService senderService;

    @RabbitListener(queues = RabbitmqConfig.QUEUE)
    public void processTransaction(TransactionPayload payload) {
        log.info("Received Transaction: {}", payload);
        senderService.sendMail(payload);
    }
}
