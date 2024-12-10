package dev.daliya.productService.inheritancedemo.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ST_User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}

//discriminator column is used to differentiate between the different types of entities in the single table strategy.
//discriminator value is used to specify the value of the discriminator column for the entity.
//In this case, the discriminator column is user_type, and the discriminator value for the User entity is 0.
//The Mentor entity will have a discriminator value of 1, and the TA entity will have a discriminator value of 2.
//This allows us to differentiate between the different types of entities when querying the database.
//The discriminator column and discriminator value are optional, but they can be useful for identifying the type of entity in the single table strategy.
//The discriminator column can be of any type, but it is typically an integer or a string.
