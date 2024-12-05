package com.pdp.mail.mapper;

import com.pdp.mail.api.request.MailRequest;
import com.pdp.mail.persistent.postgres.entity.MailsEntity;
import org.springframework.stereotype.Component;

@Component
public class MailMapper {

    public MailsEntity toEntity(MailRequest request) {
        var mail = new MailsEntity();
        mail.setId(request.getId());
        mail.setEmail(request.getEmail());
        mail.setUserId(request.getUserId());

        return mail;
    }
}
