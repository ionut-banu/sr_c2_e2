package com.example.sr_c2_e2.proxy;

import com.example.sr_c2_e2.model.Product;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ProductProxy {

    private final WebClient webClient;

    public Flux<Product> getAll() {
        return webClient.get().uri("/product")
                        .exchangeToFlux(res -> res.bodyToFlux(Product.class));
    }
}
