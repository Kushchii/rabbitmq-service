package com.pdp.mail.persistent.postgres.entity;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("mails")
public class MailsEntity {

    @Id
    @Column("id")
    private UUID id;

    @Column("user_id")
    private String userId;

    @Column("email")
    private String email;
}