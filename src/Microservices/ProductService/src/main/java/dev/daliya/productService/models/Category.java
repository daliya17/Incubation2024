package dev.daliya.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseModel {
    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;
}

// @Entity annotation specifies that the class is an entity and is mapped to a database table.
// @oneToMany annotation is used to specify a one-to-many relationship between two entities., here many products can be in one category.
// @fetch annotation is used to specify the fetching strategy of the association.
// fetchtype.eager is used to specify that the association is to be fetched eagerly, here all the products of the category are fetched eagerly.
// @mappedby annotation is used to specify the mapping of the association on the owner side.
// fetchmode.subselect is used to specify the fetching strategy of the association, subselect is used to fetch the association in a separate select statement.
