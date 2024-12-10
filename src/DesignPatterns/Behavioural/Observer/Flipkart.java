package DesignPatterns.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {

    private final List<OrderPlacedSubscriber> orderPlacedSubscribers = new ArrayList<>();

    public void addSubscriber(OrderPlacedSubscriber orderPlacedSubscriber) {
        orderPlacedSubscribers.add(orderPlacedSubscriber);
    }

    public void removeSubscriber(OrderPlacedSubscriber orderPlacedSubscriber) {
        orderPlacedSubscribers.remove(orderPlacedSubscriber);
    }

    public void orderPlaced(Order order){
        orderPlacedSubscribers.forEach(subscriber -> subscriber.onOrderPlaced(order));
    }
}
