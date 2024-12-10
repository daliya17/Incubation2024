package com.example.paymentservice.controller;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody Payment payment) {
        boolean success = paymentService.processPayment(payment);
        if (!success) {
            return ResponseEntity.badRequest().body("Invalid payment amount");
        }
        return ResponseEntity.ok("Payment processed successfully");
    }

    @PostMapping("/refund")
    public ResponseEntity<String> refundPayment(@RequestBody Payment payment) {
        paymentService.refundPayment(payment);
        return ResponseEntity.ok("Payment refunded.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPayment(id));
    }
}
