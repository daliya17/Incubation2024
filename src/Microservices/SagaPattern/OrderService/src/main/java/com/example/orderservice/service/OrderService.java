package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean createOrder(Order order) {
        if (order.getAmount() < 0) {
            return false;
        }
        orderRepository.save(order);
        return true;
    }

    @RabbitListener(queues = {"paymentQueue", "shippingQueue"})
    public void handleOrderCancellationEvent(String message) {
        if (message.contains("PAYMENT-REFUND") || message.contains("SHIPPING-FAILURE")) {
            System.out.println("Payment failure event received: " + message);
            int orderIdStartIndex = message.indexOf("orderId: ");

            // Ensure "orderId: " exists in the message
            if (orderIdStartIndex != -1) {
                orderIdStartIndex += "orderId: ".length(); // Move past "orderId: "

                // Find the index of the space after the orderId
                int orderIdEndIndex = message.indexOf(" ", orderIdStartIndex);

                // If space is not found, take the rest of the string as the orderId
                if (orderIdEndIndex == -1) {
                    orderIdEndIndex = message.length();
                }

                String orderIdStr = message.substring(orderIdStartIndex, orderIdEndIndex);

                try {
                    // Convert orderId to long
                    long orderId = Long.parseLong(orderIdStr);

                    // Handle the shipping failure
                    System.out.println("Shipping failed for order ID: " + orderId);

                    Order order = getOrder(orderId);
                    if (order != null) {
                        cancelOrder(order);
                        System.out.println("Order canceled: " + orderId);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing the orderId.");
                }
            } else {
                System.out.println("Invalid input format. Could not find 'orderId:' in the message.");
            }
        }
    }

    public void cancelOrder(Order order) {
        orderRepository.delete(order);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
