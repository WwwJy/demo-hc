package com.demo.io.data.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by w景洋
 * on 2018/10/29.
 */
@Configuration
public class AmqpConfig {

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("amq.direct");
    }

    @Bean(name="test_message")
    public Queue queueMessage() {
        return new Queue("test_message");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("test_message") Queue queueMessage, DirectExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("test_message");
    }
}
