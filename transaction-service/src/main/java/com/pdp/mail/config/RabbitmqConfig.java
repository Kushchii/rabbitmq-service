package com.pdp.mail.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {


    public static final String QUEUE = "transaction-queue";
    public static final String EXCHANGE = "transaction-exchange";
    public static final String ROUTING_KEY = "transactionRoutingKey";

    @Bean
    public Queue transactionQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public TopicExchange transactionExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding transactionBinding(Queue transactionQueue, TopicExchange transactionExchange) {
        return BindingBuilder.bind(transactionQueue).to(transactionExchange).with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
