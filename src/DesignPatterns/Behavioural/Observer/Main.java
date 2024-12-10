package DesignPatterns.Behavioural.Observer;

public class Main {
    // obeserver pattern is used when there is one-to-many relationship between objects
    // such as if one object is modified, its dependent objects are to be notified automatically
    // observer pattern falls under behavioural pattern category
    // observer pattern uses three actor classes
    // Subject: maintains a list of observers, facilitates addition or removal of observers
    // Observer: provides a update interface for objects that need to be notified of a Subject's changes of state
    // ConcreteSubject: broadcasts notifications to observers on changes of state, stores the state of ConcreteObservers
    public static void main(String[] args) {
        Flipkart flipkart = new Flipkart();

        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem(flipkart);
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(flipkart);
        EmailService emailService = new EmailService(flipkart);
        SMSService smsService = new SMSService(flipkart);

        Order order = new Order();
        order.setOrderId(1L);
        order.setProductId(1L);
        order.setCustomerName("John Doe");
        order.setCustomerEmail("daliyajohnson33@gmail.com");
        order.setCustomerPhoneNumber("1234567890");

        flipkart.orderPlaced(order);
    }
}
