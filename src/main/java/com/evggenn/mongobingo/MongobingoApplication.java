package com.evggenn.mongobingo;

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
			ProductRepository productRepository) {
		return args -> {
			var product = Product.builder()
					.name("iphone")
					.description("Smart Phone")
					.build();
			productRepository.insert(product);
		};
	}

}
