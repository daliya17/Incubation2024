package DesignPatterns.Behavioural.Observer;

public class EmailService implements OrderPlacedSubscriber {

    EmailService(Flipkart flipkart) {
        flipkart.addSubscriber(this);
    }

    @Override
    public void onOrderPlaced(Order order) {
        sendEmail(order.getCustomerEmail(), "Your order has been placed successfully!");
    }

    void sendEmail(String to, String body) {
        System.out.println("Email sent to: " + to + " with body: " + body);
    }
}
