package dev.daliya.productService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends BaseModel {

    private String title;

    private String description;

    private String image;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;

}

// @cascade annotation is used to specify the operations that must be cascaded to the target of the association, in this case, the category and price, when the source of the association is updated or removed.
// cascade type persist means that save() or persist() operations cascade to related entities.
// example: persist, remove, refresh, merge, detach, all, etc.
