package com.pdp.mail.service;

import com.pdp.mail.api.request.MailRequest;
import com.pdp.mail.api.response.MailResponse;
import reactor.core.publisher.Mono;

public interface MailService {

    Mono<MailResponse> mails(MailRequest request);
}
