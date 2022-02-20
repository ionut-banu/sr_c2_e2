package com.example.sr_c2_e2.handler;

import com.example.sr_c2_e2.model.Product;
import com.example.sr_c2_e2.service.ProductService;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductService productService;

    public Mono<ServerResponse> getAll(ServerRequest req) {
        return ok().contentType(TEXT_EVENT_STREAM).body(productService.getAll(), Product.class);
    }
}
