package com.example.shippingservice.service;

import com.example.shippingservice.model.Shipment;
import com.example.shippingservice.repository.ShipmentRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private final ShipmentRepository shipmentRepository;
    private final AmqpTemplate rabbitTemplate;

    public ShippingService(ShipmentRepository shipmentRepository, AmqpTemplate rabbitTemplate) {
        this.shipmentRepository = shipmentRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "paymentQueue")
    public void handlePaymentSuccessEvent(String message){
        System.out.println("Payment success event received: " + message);
        if(message.contains("PAYMENT-SUCCESS")) {
            System.out.println("Shipping order");
            int orderIdStartIndex = message.indexOf("order: ");

            // Ensure "order: " is found in the message
            if (orderIdStartIndex != -1) {
                // Adjust start index to the actual start of the orderId
                orderIdStartIndex += "order: ".length();

                // Find the index of the space after the orderId
                int orderIdEndIndex = message.indexOf(" ", orderIdStartIndex);

                // If space is not found, take the rest of the string as the orderId
                if (orderIdEndIndex == -1) {
                    orderIdEndIndex = message.length();
                }

                // Extract orderId as a string
                String orderIdStr = message.substring(orderIdStartIndex, orderIdEndIndex);

                try {
                    // Convert orderId to long
                    long orderId = Long.parseLong(orderIdStr);

                    // Output the converted orderId
                    System.out.println("Order ID: " + orderId);
                    boolean success = shipOrder(new Shipment(orderId, "123 Main St, San Francisco, CA"));
                    if(success) {
                        System.out.println("Order shipped successfully");
                    } else {
                        rabbitTemplate.convertAndSend("saga_exchange", "", "SHIPPING-FAILURE for orderId: " + orderId);
                        System.out.println("Order shipping failed");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing the orderId.");
                }
            } else {
                System.out.println("Invalid input format. Could not find 'order:' in the message.");
            }

        }
    }
    public boolean shipOrder(Shipment shipment) {
        if(shipment == null || shipment.getOrderId() == null || shipment.getAddress() == null || shipment.getAddress().isEmpty()) {
            return false;
        }
        shipmentRepository.save(shipment);
        return true;
    }

    public Shipment getShipment(Long id) {
        return shipmentRepository.findById(id).orElse(null);
    }
}
