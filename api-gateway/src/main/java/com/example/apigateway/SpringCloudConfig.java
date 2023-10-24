package com.example.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder, ForwardHeadersFilter forwardHeadersFilter) {
        return builder.routes()
                .route(r -> r.path("/api/cours/**")
                        .uri("http://cours:8082/"))
                .route(r -> r.path("/api/users/**")
                        .filters(f -> f.filter(myForwardHeadersFilter())) // Add the custom filter here
                        .uri("http://user:7070/"))
                .route(r -> r.path("/api/comments/**")
                        .uri("http://comment:8085/"))
                .route(r -> r.path("/api/posts/**")
                        .uri("http://post:8090/"))
                .route(r -> r.path("/api/quiz/**")
                        .uri("http://quizz:8009/"))
                .build();
    }

    @Bean
    public ForwardHeadersFilter myForwardHeadersFilter() {
        return new ForwardHeadersFilter();
    }
}

@Component
class ForwardHeadersFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        ServerHttpRequest.Builder requestBuilder = request.mutate();

        headers.forEach((headerName, headerValues) -> {
            requestBuilder.header(headerName, headerValues.toArray(new String[0]));
        });

        ServerHttpRequest newRequest = requestBuilder.build();
        ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();

        return chain.filter(newExchange);
    }
}
