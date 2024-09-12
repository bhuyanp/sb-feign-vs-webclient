package com.example.webclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final WebClientService webClientService;

    @GetMapping
    public ResponseEntity<Flux<Product>> getAll(){
        log.info("Fetching products");
        return ResponseEntity.ok(webClientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Product>> getById(@PathVariable String id) throws ExecutionException, InterruptedException {
        log.info("Fetching product: {}",id);
        return ResponseEntity.ok(webClientService.getById(id));
    }
}
