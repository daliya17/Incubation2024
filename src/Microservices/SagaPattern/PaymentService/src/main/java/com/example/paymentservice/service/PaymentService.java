package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final AmqpTemplate rabbitTemplate;

    public PaymentService(PaymentRepository paymentRepository, AmqpTemplate rabbitTemplate) {
        this.paymentRepository = paymentRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    // listen for order events
    @RabbitListener(queues = "orderQueue")
    public void handleOrderEvent(String message) {
        if (!message.contains("ORDER_CREATED")) {
            return;
        }
        System.out.println("Order event received: " + message);
        int orderIdStartIndex = message.indexOf("orderId: ");
        int amountStartIndex = message.indexOf("amount: ");

        // Check if the indexes are valid (i.e., not -1)
        if (orderIdStartIndex != -1 && amountStartIndex != -1) {
            // Adjust start indices to the actual start of the values
            orderIdStartIndex += "orderId: ".length();
            amountStartIndex += "amount: ".length();

            // Find the index of the space after the orderId and amount
            int orderIdEndIndex = message.indexOf(" ", orderIdStartIndex);
            int amountEndIndex = message.indexOf(" ", amountStartIndex);

            // If the space after orderId or amount is not found, handle it
            if (orderIdEndIndex == -1) {
                orderIdEndIndex = message.length();  // Take the rest of the string if no space found
            }
            if (amountEndIndex == -1) {
                amountEndIndex = message.length();  // Take the rest of the string if no space found
            }

            // Extract orderId and amount as strings
            String orderIdStr = message.substring(orderIdStartIndex, orderIdEndIndex);
            String amountStr = message.substring(amountStartIndex, amountEndIndex);

            try {
                // Convert orderId to long and amount to double
                long orderId = Long.parseLong(orderIdStr);
                double amount = Double.parseDouble(amountStr);

                // Output the converted values
                System.out.println("Order ID: " + orderId);

                System.out.println("Processing payment for order: " + orderId + " with amount: " + amount);
                boolean success = processPayment(new Payment(orderId, amount, "PENDING"));
                if (success) {
                    // send payment success event to shipping service
                    rabbitTemplate.convertAndSend("saga_exchange", "", "PAYMENT-SUCCESS for order: " + orderId);
                } else {
                    // send payment failure event to cancel order
                    rabbitTemplate.convertAndSend("saga_exchange", "", "PAYMENT-FAILURE for order: " + orderId);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing the orderId or amount.");
            }
        } else {
            System.out.println("Invalid input format. Could not find 'orderId:' or 'amount:' in the message.");
        }

    }

    @RabbitListener(queues = "shippingQueue")
    public void handleShippingFailure(String message) {
        if (message.contains("SHIPPING-FAILURE")) {
            System.out.println("Shipping failure event received: " + message);
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
                    Payment payment = getPayment(orderId);
                    if (payment != null) {
                        refundPayment(payment);
                        rabbitTemplate.convertAndSend("saga_exchange", "", "PAYMENT-REFUND for orderId: " + orderId);
                        System.out.println("Payment refunded for order: " + orderId);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing the orderId.");
                }
            } else {
                System.out.println("Invalid input format. Could not find 'orderId:' in the message.");
            }

        }
    }

    public boolean processPayment(Payment payment) {
        if (payment.getAmount() < 0) {
            return false;
        }
        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);
        return true;
    }

    public void refundPayment(Payment payment) {
        payment.setStatus("REFUNDED");
        paymentRepository.save(payment);
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
