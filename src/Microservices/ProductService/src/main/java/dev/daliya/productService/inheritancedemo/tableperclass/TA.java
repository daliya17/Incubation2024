package dev.daliya.productService.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "TPC_TA")
public class TA extends User {
    private double averageRating;
}

// table per class strategy creates a separate table for each class in the hierarchy.
// The parent class is also an entity and is mapped to a database table.
// The child classes are also entities and are mapped to separate database tables.
// The child class tables have a primary key that is also a foreign key to the parent class table.

// The table per class strategy is useful when the child classes have a lot of fields that are not shared with other child classes.
// It allows each child class to have its own table with its own fields, without duplicating the fields of the parent class.
// differnec between table per class and joined table:
// In the table per class strategy, each class in the hierarchy has its own table, and the parent class table does not contain the fields of the child classes.
// In the joined table strategy, each class in the hierarchy has its own table, and the parent class table contains all the fields of the child classes.
