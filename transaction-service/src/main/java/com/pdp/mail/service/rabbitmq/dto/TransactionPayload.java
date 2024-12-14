package com.pdp.mail.service.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TransactionPayload {

    private UUID id;

    private String status;

    private String userId;
}
