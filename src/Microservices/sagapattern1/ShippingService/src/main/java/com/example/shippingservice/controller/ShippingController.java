package com.example.shippingservice.controller;

import com.example.shippingservice.model.Shipment;
import com.example.shippingservice.service.ShippingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping("/ship")
    public ResponseEntity<String> shipProduct(@RequestBody Shipment shipment) {
       boolean success = shippingService.shipOrder(shipment);
         if (!success) {
              return ResponseEntity.badRequest().body("Invalid shipment details");
         }
            return ResponseEntity.ok("Shipment processed successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipment(@PathVariable Long id) {
        return ResponseEntity.ok(shippingService.getShipment(id));
    }
}
