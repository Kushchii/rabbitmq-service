package com.pdp.mail.service;

import com.pdp.mail.api.request.MailRequest;
import com.pdp.mail.api.response.MailResponse;
import com.pdp.mail.mapper.MailMapper;
import com.pdp.mail.persistent.repository.MailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    private final MailMapper mailMapper;
    private final MailsRepository mailsRepository;

    @Override
    public Mono<MailResponse> mails(MailRequest request) {
        var entity = mailMapper.toEntity(request);
        return mailsRepository.save(entity)
                .flatMap(mail -> Mono.just(new MailResponse("Mail saved successfully")));
    }
}
