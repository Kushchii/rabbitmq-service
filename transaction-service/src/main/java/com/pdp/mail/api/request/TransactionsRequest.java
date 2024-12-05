package com.pdp.mail.api.request;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class TransactionsRequest {

    @NotBlank
    private UUID id;

    @NotBlank
    private String status;

    @NotBlank
    private String userId;

    @NotBlank
    private BigDecimal amount;

    @NotBlank
    private String currency;

    @NotBlank
    private String description;
}
