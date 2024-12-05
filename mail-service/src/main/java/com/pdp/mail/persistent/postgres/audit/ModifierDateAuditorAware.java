package com.pdp.mail.persistent.postgres.audit;

import org.springframework.data.domain.ReactiveAuditorAware;
import reactor.core.publisher.Mono;

public class ModifierDateAuditorAware implements ReactiveAuditorAware<String> {

    @Override
    public Mono<String> getCurrentAuditor() {
        return Mono.empty();
    }
}
