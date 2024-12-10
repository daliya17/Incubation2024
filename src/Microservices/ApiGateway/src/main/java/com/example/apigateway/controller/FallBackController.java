package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @RequestMapping("/fallback/user")
    public String userServiceFallBackMethod() {
        return "User service is taking longer than expected." +
                " Please try again later";
    }

    @RequestMapping("/fallback/product")
    public String productServiceFallBackMethod() {
        return "Product service is taking longer than expected." +
                " Please try again later";
    }
}
