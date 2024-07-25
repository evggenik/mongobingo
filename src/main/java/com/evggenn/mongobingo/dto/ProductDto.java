package com.evggenn.mongobingo.dto;

import com.evggenn.mongobingo.category.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.util.List;

public record ProductDto(
        String id,
        @NotNull
        String name,
        String description,
        List<String>tags,
        @NotEmpty(message = "You should select category")
        Category category
) {
}
