package dev.daliya.productService.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "JT_Mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private double averageMentorRating;
}
