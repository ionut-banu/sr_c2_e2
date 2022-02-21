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
        var p = new Product("Default");
        return webClient.get().uri("/product")
                        .exchangeToFlux(res -> res.bodyToFlux(Product.class))
                        //                          .onErrorResume(e -> Flux.just(p));
                        //                          .onErrorResume(WebClientRequestException.class, e -> Flux.just(p));
                        //                          .onErrorResume(e -> e instanceof WebClientRequestException, e -> Flux.just(p));
                        //                          .onErrorReturn(p);
                        //                          .onErrorReturn(WebClientRequestException.class, p);
                        //                          .onErrorReturn(e -> e.getMessage() == null, p);
                        //                          .onErrorMap(e -> new ProductRetrieveException());
                        //                          .doOnNext(n -> {
                        //                              if (n.getName() == null) {
                        //                                  throw new RuntimeException();
                        //                              }
                        //                          })
                        //                          .onErrorContinue((e, o) -> System.out.println(e.getMessage()));
                        //                          .onErrorContinue(RuntimeException.class, (e, o) -> System.out.println(e.getMessage()));
                        //                          .onErrorContinue(e->e.getMessage() == null, (e, o) -> System.out.println(e.getMessage()));
                        //                          .retry();
                        .retry(3);

    }
}
