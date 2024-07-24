package com.evggenn.mongobingo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(
            @RequestBody Product product
    ) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Product> findById(
            @PathVariable("product-id") String id
    ) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("product-id") String id
    ) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
