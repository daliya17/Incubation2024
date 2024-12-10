package DesignPatterns.Behavioural.Observer;

public class SMSService implements OrderPlacedSubscriber {

    SMSService(Flipkart flipkart) {
        flipkart.addSubscriber(this);
    }

    @Override
    public void onOrderPlaced(Order order) {
        sendSMS(order.getCustomerPhoneNumber(), "Your order has been placed successfully!");
    }

    void sendSMS(String to, String body) {
        System.out.println("SMS sent to: " + to + " with body: " + body);
    }
}
