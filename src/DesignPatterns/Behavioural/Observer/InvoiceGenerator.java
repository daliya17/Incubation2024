package DesignPatterns.Behavioural.Observer;

public class InvoiceGenerator implements OrderPlacedSubscriber {

    InvoiceGenerator(Flipkart flipkart) {
        flipkart.addSubscriber(this);
    }

    @Override
    public void onOrderPlaced(Order order) {
        generateInvoice(order.getOrderId());
    }

    void generateInvoice(Long orderId) {
        System.out.println("Invoice generated for order: " + orderId);
    }
}
