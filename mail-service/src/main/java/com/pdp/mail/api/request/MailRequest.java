package com.pdp.mail.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class MailRequest {

    @NotBlank
    private UUID id;

    @NotBlank
    private String userId;

    @NotBlank
    private String email;
}
