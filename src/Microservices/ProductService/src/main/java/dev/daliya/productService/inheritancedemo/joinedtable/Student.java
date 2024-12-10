package dev.daliya.productService.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "JT_Student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    private double psp;
    private double attendance;
}
