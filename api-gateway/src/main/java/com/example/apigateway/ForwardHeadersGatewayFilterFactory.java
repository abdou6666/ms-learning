package com.example.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ForwardHeadersGatewayFilterFactory extends AbstractGatewayFilterFactory<ForwardHeadersGatewayFilterFactory.Config> {

    public ForwardHeadersGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            exchange.getRequest()
                    .getHeaders()
                    .forEach((headerName, headerValues) -> {
                        // Check if the header name is in the list of headers to forward
                            headerValues.forEach(headerValue -> {
                                exchange.getRequest().mutate()
                                        .header(headerName, headerValue);
                            });

                    });
            return chain.filter(exchange);
        };
    }

    public static class Config {
        private List<String> headersToForward = new ArrayList<>();

        public List<String> getHeadersToForward() {
            return headersToForward;
        }

        public void setHeadersToForward(List<String> headersToForward) {
            this.headersToForward = headersToForward;
        }
    }
}
