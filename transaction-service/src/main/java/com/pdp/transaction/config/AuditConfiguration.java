package com.pdp.transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import reactor.core.publisher.Mono;

@Configuration
@EnableR2dbcAuditing
public class AuditConfiguration {

    @Bean
    public ReactiveAuditorAware<String> myAuditorProvider() {
        return Mono::empty;
    }
}