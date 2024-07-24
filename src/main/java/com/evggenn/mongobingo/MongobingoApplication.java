package com.evggenn.mongobingo;

import com.evggenn.mongobingo.category.Category;
import com.evggenn.mongobingo.category.CategoryRepository;
import com.evggenn.mongobingo.product.Product;
import com.evggenn.mongobingo.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongobingoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongobingoApplication.class, args);
	}

//	@Bean
	public CommandLineRunner commandLineRunner(
//			ProductRepository productRepository,
			CategoryRepository categoryRepository
	) {
		return args -> {
			var category1 = Category.builder()
					.name("cat 1")
					.description("category")
					.build();

			var category2 = Category.builder()
					.name("cat 2")
					.description("category")
					.build();
			categoryRepository.insert(category2);
			categoryRepository.insert(category1);
		};
	}

}
