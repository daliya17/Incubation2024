package com.example.paymentservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private Double amount;

    public Order() {}

    public Order(String customerId, Double amount) {
        this.customerId = customerId;
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
