package com.example.feignclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final ProductFeignClient productFeignClient;
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        log.info("Fetching products");
        return ResponseEntity.ok(productFeignClient.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id){
        log.info("Fetching product: {}",id);
        return ResponseEntity.ok(productFeignClient.get(id));
    }
}
