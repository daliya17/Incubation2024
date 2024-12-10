package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.core.AmqpTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private final AmqpTemplate rabbitTemplate;

    public OrderController(OrderService orderService, AmqpTemplate rabbitTemplate) {
        this.orderService = orderService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        boolean success = orderService.createOrder(order);
        if (success) {
            // send order to the exchange for payment processing
            rabbitTemplate.convertAndSend("saga_exchange", "", "ORDER_CREATED with orderId: " + order.getId() + " and amount: " + order.getAmount() + " ");
            return ResponseEntity.ok("Order created successfully " + order.getId());
        } else {
            return ResponseEntity.badRequest().body("Invalid order amount");
        }
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelOrder(@RequestBody Order order) {
        orderService.cancelOrder(order);
        return ResponseEntity.ok("Order canceled.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }
}
