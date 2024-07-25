package com.evggenn.mongobingo.dto;

import com.evggenn.mongobingo.product.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getTags(),
                product.getCategory()
        );
    }

    public Product toProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.id())
                .name(productDto.name())
                .description(productDto.description())
                .tags(productDto.tags())
                .category(productDto.category())
                .build();
    }

}
