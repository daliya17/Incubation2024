package com.example.orderservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // fanout exchange is used to broadcast messages to all queues bound to it
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("saga_exchange");
    }

    // define Queues
    // durable = true means that the queue will survive broker restarts
    @Bean
    public Queue orderQueue(){
        return new Queue("orderQueue", true);
    }

    @Bean
    public Queue paymentQueue(){
        return new Queue("paymentQueue", true);
    }

    @Bean
    public Queue shippingQueue(){
        return new Queue("shippingQueue", true);
    }

    @Bean
    public Queue refundQueue(){
        return new Queue("refundQueue", true);
    }

    // bind Queues to the fanout exchange
    @Bean
    public Binding bindingOrder(){
        return BindingBuilder.bind(orderQueue()).to(fanout());
    }

    @Bean
    public Binding bindingPayment(){
        return BindingBuilder.bind(paymentQueue()).to(fanout());
    }

    @Bean
    public Binding bindingShipping(){
        return BindingBuilder.bind(shippingQueue()).to(fanout());
    }
}
