package dev.daliya.productService.inheritancedemo.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}


// in joined table strategy, each entity has its own table in the database, and the parent class table contains all the fields of the child classes.
// The parent class table contains a primary key column that is used to join the parent and child tables.
// The child tables contain only the fields that are specific to the child class.
// The parent class is annotated with @Inheritance(strategy = InheritanceType.JOINED), and the child classes are annotated with @Entity.
// The parent class table contains all the fields of the child classes, and the child tables contain only the fields that are specific to the child class.

// example:
// The User class is the parent class, and it contains the id, name, and email fields.
// The Student class is a child class of User, and it contains the psp and attendance fields.
// The Mentor class is another child class of User, and it contains the salary field.
// The User class is mapped to the JT_User table, and the Student and Mentor classes are mapped to the JT_Student and JT_Mentor tables, respectively.
// The JT_User table contains the id, name, and email fields, and the JT_Student table contains the psp and attendance fields.
// The JT_Mentor table contains the salary field.
// The JT_User table has a primary key column that is used to join the JT_Student and JT_Mentor tables.
// The joined table strategy allows us to model inheritance in a relational database while avoiding null values and data redundancy.