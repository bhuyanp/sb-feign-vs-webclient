package com.example.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")
public interface ProductFeignClient {
    @GetMapping("/api/products")
    List<Product> getProducts();

    @GetMapping("/api/products/{id}")
    Product get(@PathVariable String id);
}
