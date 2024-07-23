package com.evggenn.mongobingo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String saveProduct(Product product) {
        // todo DTO and validation
        productRepository.save(product);
        return product.getId();
    }

    public Product findById(String id) {
        return productRepository.findById(id)
                .orElse(null);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

}
