package com.pdp.mail.config;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import com.pdp.mail.handler.MailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ViewResolverRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.thymeleaf.spring6.view.reactive.ThymeleafReactiveViewResolver;

@EnableWebFlux
@Configuration
@RequiredArgsConstructor
public class WebFluxConfiguration implements WebFluxConfigurer {

    //Executing the payment on a single request

    public static final String MAILS = "/api/mails";

    private final ThymeleafReactiveViewResolver thymeleafReactiveViewResolver;

    @Bean
    public RouterFunction<ServerResponse> singleStepPaymentRouterFunction(
        MailHandler handler) {
        return route()
            .POST(MAILS, handler::mails)
            .build();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafReactiveViewResolver);
    }
}
