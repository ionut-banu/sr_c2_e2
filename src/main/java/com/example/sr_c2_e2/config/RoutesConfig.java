package com.example.sr_c2_e2.config;

import com.example.sr_c2_e2.handler.ProductHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RoutesConfig {

    private final ProductHandler productHandler;

    @Bean
    public RouterFunction<ServerResponse> router() {
        return route().GET("/all", productHandler::getAll)
                      .build();
    }

}

