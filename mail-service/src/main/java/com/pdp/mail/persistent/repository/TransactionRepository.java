package com.pdp.mail.persistent.repository;

import com.pdp.mail.persistent.postgres.entity.MailsEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TransactionRepository extends R2dbcRepository<MailsEntity, Long> {

}

