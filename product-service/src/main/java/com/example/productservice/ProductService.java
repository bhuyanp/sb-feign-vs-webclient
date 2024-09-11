package com.example.productservice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final List<Product> products = List.of(
            new Product("1", "PRODUCT 1", 11.25),
            new Product("2", "PRODUCT 2", 12.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25),
            new Product("3", "PRODUCT 3", 13.25)
    );

    public List<Product> getAll() {
        return products;
    }

    public Optional<Product> getById(String id) {
        return products.stream()
                .filter(it -> it.getId().equalsIgnoreCase(id)).findAny();
    }
}
