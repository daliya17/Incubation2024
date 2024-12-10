package CoreJava.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ChainingWithCompose {
    public static void main(String[] args) {
        // Order processing
        CompletableFuture<String> fetchOrderDetails = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Order 1";
        });

        // Payment processing
        CompletableFuture<String> processPayment = fetchOrderDetails.thenCompose(order -> {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Payment Processed for " + order;
            });
        });

        // Send notification
        CompletableFuture<Void> senNotification = processPayment.thenAcceptAsync(paymentStatus -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Payment status is " + paymentStatus);
        });

        // wait for all tasks to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(fetchOrderDetails, processPayment, senNotification);
        senNotification.join();

        System.out.println("All tasks completed");
    }
}
