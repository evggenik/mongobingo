package com.evggenn.mongobingo.product;

import com.evggenn.mongobingo.dto.ProductDto;
import com.evggenn.mongobingo.dto.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public String saveProduct(ProductDto productDto) {
        // todo DTO and validation
        var product = productRepository.save(productMapper.toProduct(productDto));
        return product.getId();
    }

    public ProductDto findById(String id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found with ID:: " + id));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

}
