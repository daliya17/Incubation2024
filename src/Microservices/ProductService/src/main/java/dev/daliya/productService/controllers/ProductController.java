package dev.daliya.productService.controllers;

import dev.daliya.productService.dtos.ExceptionDto;
import dev.daliya.productService.dtos.GenericProductDto;
import dev.daliya.productService.exeptions.NotFoundException;
import dev.daliya.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

 //   @CircuitBreaker(name = "productService", fallbackMethod = "productFallback")
    @GetMapping
    public List<GenericProductDto> getALlProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.deleteProductById(id);
    }

    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable("id") UUID id, @RequestBody GenericProductDto product) throws NotFoundException {
        return productService.updateProductById(product, id);
    }

    @PatchMapping("{id}")
    public GenericProductDto updateProductPriceById(@PathVariable("id") UUID id, @RequestBody GenericProductDto product) throws NotFoundException {
        return productService.updateProductPriceById(product, id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    public String productFallback(Exception e) {
        return "Product service is currently unavailable. Please try again later.";
    }

}
