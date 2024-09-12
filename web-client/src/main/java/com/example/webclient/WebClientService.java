package com.example.webclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebClientService {
    private final WebClient.Builder webClientBuilder;

    public Flux<Product> getAll() {
        return webClientBuilder.build().get().uri("lb://product-service/api/products")
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Mono<Product> getById(String id) throws ExecutionException, InterruptedException {
        log.info("Fetching product for id {}",id);
        return webClientBuilder.build().get().uri("lb://product-service/api/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class);

    }
}
