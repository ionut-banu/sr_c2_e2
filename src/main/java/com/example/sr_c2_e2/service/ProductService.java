package com.example.sr_c2_e2.service;

import com.example.sr_c2_e2.model.Product;
import com.example.sr_c2_e2.proxy.ProductProxy;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductProxy productProxy;

    public Flux<Product> getAll() {
        return productProxy.getAll();
    }
}
