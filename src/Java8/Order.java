package Java8;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    public int id;
    public String name;
    public int quantity;
    public LocalDate orderDate;
    public List<Product> products;

    public Order(int id, String name, int quantity, LocalDate orderDate, List<Product> products){
        this.id=id;
        this.name=name;
        this.quantity=quantity;
        this.products=products;
        this.orderDate=orderDate;
    }
}
