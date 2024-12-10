package dev.daliya.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order extends BaseModel {

    @ManyToMany
    @JoinTable(name = "product_order", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

}

// many-to-many relationship between order and product, many products can be in one order and one product can be in many orders.
// @manyToMany annotation is used to specify a many-to-many relationship between two entities.
// @jointable annotation is used to specify the join table for the relationship.
// joincolumns annotation is used to specify the foreign key column in the join table that references the primary table.
// inversejoincolumns annotation is used to specify the foreign key column in the join table that references the secondary table.









