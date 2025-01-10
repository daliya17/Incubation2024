package dev.daliya.productService.inheritancedemo.mappedsuperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}

// in mapped superclass, the parent class is not an entity, but the child classes are entities
// The parent class is annotated with @MappedSuperclass, and the child classes are annotated with @Entity.
// The child classes inherit the fields and methods of the parent class, but the parent class is not an entity and is not mapped to a database table.
