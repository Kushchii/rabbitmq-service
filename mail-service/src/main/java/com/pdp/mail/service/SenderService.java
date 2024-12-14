package com.pdp.mail.service;

import com.pdp.mail.persistent.repository.MailsRepository;
import com.pdp.mail.service.rabbitmq.dto.TransactionPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SenderService {

    private final MailsRepository mailsRepository;

    public void sendMail(TransactionPayload payload) {
        mailsRepository.findByUserId(payload.getUserId())
                .doOnNext(mail -> log.info("Mail with id: {} and status: {} was send to email: {}", payload.getId(), payload.getStatus(), mail.getEmail()))
                .subscribe();
    }
}
