package com.evggenn.mongobingo.product;

import com.evggenn.mongobingo.dto.ProductDto;
import jakarta.validation.Valid;
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
            @RequestBody @Valid ProductDto productDto
    ) {
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductDto> findById(
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
