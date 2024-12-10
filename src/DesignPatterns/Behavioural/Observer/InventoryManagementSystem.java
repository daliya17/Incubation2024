package DesignPatterns.Behavioural.Observer;

public class InventoryManagementSystem implements OrderPlacedSubscriber {

    InventoryManagementSystem(Flipkart flipkart) {
        flipkart.addSubscriber(this);
    }

    @Override
    public void onOrderPlaced(Order order) {
        updateInventory(order.getProductId());
    }

    void updateInventory(Long productId) {
        System.out.println("Inventory updated for product: " + productId);
    }
}
