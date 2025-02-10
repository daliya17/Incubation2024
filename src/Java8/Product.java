package Java8;

import lombok.Data;

@Data
public class Product {
    public int id;
    public String name;
    public double price;
    public String category;

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

}
