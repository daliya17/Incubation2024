package com.example.shippingservice.repository;

import com.example.shippingservice.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
